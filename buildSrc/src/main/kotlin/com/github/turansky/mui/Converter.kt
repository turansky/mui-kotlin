package com.github.turansky.mui

import java.io.File

private const val UNION_MARKER = """/*union*/"""

internal data class ConversionResult(
    val main: String,
    val extensions: String,
)

internal fun convertClasses(
    classesName: String,
    definitionFile: File,
): String {
    val content = definitionFile.readText()
        .replace("\r\n", "\n")

    val classes = content.substringAfter("export interface $classesName {\n")
        .substringBefore("\n}\n")
        .trimIndent()
        .splitToSequence("\n")
        .map {
            val name = it.removeSuffix(": string;")
            if (name == it) return@map it
            val line = "var $name: String"
            if (name.startsWith("'")) "    // $line" else line
        }
        .joinToString("\n")

    return "external interface $classesName {\n" +
            "$classes\n" +
            "}\n"
}

internal fun convertDefinitions(
    definitionFile: File,
): ConversionResult {
    val name = definitionFile.name.substringBefore(".")

    val content = definitionFile.readText()
        .replace("\r\n", "\n")
        .removeInlineClasses()

    val declarations = mutableListOf<String>()

    val propsName = "${name}Props"

    findProps(name, propsName, content)
        ?.also(declarations::add)

    findMapProps(name, propsName, content)
        ?.also(declarations::add)

    declarations += findAdditionalProps(propsName, content)

    val funDeclaration = "export default function $name(props: $propsName): JSX.Element;"
    val typeDeclaration = "declare const $name: React.ComponentType<$propsName>;"
    val constDeclaration = "declare const $name: "

    declarations += listOfNotNull(
        findComponent(name, propsName, funDeclaration, content),
        findComponent(name, propsName, typeDeclaration, content, "ComponentType"),
        findComponent(name, propsName, constDeclaration, content),
    ).take(1)

    val enums = content.splitToSequence("export type ")
        .drop(1)
        .map { it.substringBefore(";") }
        .mapNotNull { convertUnion(it) }
        .toList()

    val mainContent = fixOverrides(
        name = name,
        content = declarations.joinToString("\n\n")
    )

    return ConversionResult(
        main = mainContent,
        extensions = enums.joinToString("\n\n"),
    )
}

private fun String.removeInlineClasses(): String =
    removeInlineClasses("  classes: ")
        .removeInlineClasses("  classes?: ")

private fun String.removeInlineClasses(
    trigger: String,
): String {
    if (trigger !in this)
        return this

    val parts = split(trigger)
    if (parts.size != 2)
        return this

    val (s, e) = parts

    val type = when {
        e.startsWith("Partial<ButtonClasses> & {")
        -> "mui.material.ButtonClasses"

        e.startsWith("{")
        -> "unknown"

        else -> return this
    }

    return s + "  classes?: $type;" + e.substringAfter("};")
}

private fun findProps(
    name: String,
    propsName: String,
    content: String,
): String? {
    when (name) {
        "TextField",
        "TreeView",
        -> return props(propsName)
    }

    val propsContent = sequenceOf(" ", "<", "\n")
        .map { content.substringAfter("export interface $propsName$it", "") }
        .singleOrNull { it.isNotEmpty() }
        ?: return null

    var parentType: String? = null
    if (" extends " in content) {
        val parentSource = content
            .substringAfter(" extends ")
            .substringBefore(" {\n")

        when {
            "<TDate>" in parentSource -> Unit

            parentSource.startsWith("StandardProps<") -> {
                parentType = sequenceOf(
                    "mui.system.StandardProps",
                    parentSource
                        .removeSurrounding("StandardProps<", ">")
                        .substringBefore(",")
                        .toTypeParameter()
                ).joinToString(",\n", "\n")
            }

            parentSource.startsWith("Omit<") -> {
                parentType = parentSource
                    .removeSurrounding("Omit<", ">")
                    .substringBefore(",")
                    .toTypeParameter()
            }

            parentSource == "ListProps"
            -> parentType = parentSource

            parentSource == "HTMLDivProps"
            -> parentType = "react.dom.html.HTMLAttributes<org.w3c.dom.HTMLDivElement>"

            parentSource == "TransitionProps"
            -> parentType = parentSource.toTypeParameter()

            parentSource == "React.HTMLAttributes<HTMLSpanElement>"
            -> parentType = parentSource.toTypeParameter()
        }
    }

    val source = propsContent
        .substringAfter("{\n")

    val membersContent = source
        .takeIf { !it.startsWith("}\n") }
        ?.substringBefore(";\n}")
        ?: ""

    val body = convertMembers(membersContent)
    return props(propsName, parentType, CHILDREN in body) + " {\n" +
            body +
            "\n}"
}

private fun findMapProps(
    name: String,
    propsName: String,
    content: String,
): String? {
    val propsContent = sequenceOf(
        content.substringAfter("export interface ${name}TypeMap<", "")
            .substringBefore("\n}\n"),
        content.substringAfter("export type ${name}TypeMap<", "")
            .substringBefore("\n}>;\n"),
    ).firstOrNull { it.isNotEmpty() }
        ?: return null

    val intrinsicType = propsContent
        .substringBefore(" {\n")
        .substringAfter(" D extends React.ElementType = '", "")
        .substringBefore("'", "")

    val parentType: String? = INTRINSIC_TYPE_MAP[intrinsicType]

    val membersContent = propsContent
        .substringAfter("props: P", "")
        .substringAfter(" & {\n", "")
        .let { str ->
            sequenceOf(
                str.substringBefore(";\n    };", ""),
                str.substringBefore(";\n  };", "")
            ).maxByOrNull { it.length }!!
        }

    return if (membersContent.isNotEmpty()) {
        val body = convertMembers(membersContent)
        props(propsName, parentType, CHILDREN in body) + " {\n" +
                body +
                "\n}"
    } else {
        props(propsName, parentType)
    }
}

private val ADDITIONAL_PREFIXES = setOf(
    "Origin",
    "Position",
    "Classes",
)

private fun findAdditionalProps(
    propsName: String,
    content: String,
): List<String> {
    val bodies = content.splitToSequence("export interface ")
        .drop(1)
        .toList()

    if (bodies.isEmpty())
        return emptyList()

    return bodies.mapNotNull { body ->
        val interfaceName = body
            .substringBefore(" ")
            .substringBefore("\n")
            .substringBefore("<")

        val propsLike = interfaceName.endsWith("Props")
        if (propsLike && interfaceName == propsName)
            return@mapNotNull null

        if (!propsLike && ADDITIONAL_PREFIXES.all { !interfaceName.endsWith(it) })
            return@mapNotNull null

        val membersContent = if (interfaceName != "InputBaseComponentProps") {
            body.substringAfter("{\n")
                .substringBefore(";\n}\n")
        } else ""

        val propsBody = convertMembers(membersContent)
        val declaration = if (propsLike) {
            props(interfaceName, hasChildren = CHILDREN in propsBody)
        } else {
            "external interface $interfaceName"
        }

        declaration + " {\n" +
                propsBody +
                "\n}"
    }
}

private fun props(
    propsName: String,
    parentType: String? = null,
    hasChildren: Boolean = false,
): String {
    val parentTypes = when {
        parentType == null
        -> if (hasChildren) "react.PropsWithChildren" else "react.Props"

        hasChildren
        -> sequenceOf(parentType.removePrefix("\n"), "react.PropsWithChildren")
            .joinToString(",\n", "\n")

        "\n" in parentType
        -> parentType

        else -> "\n" + parentType
    }

    return "external interface $propsName: $parentTypes"
}

private fun findComponent(
    name: String,
    propsName: String,
    declaration: String,
    content: String,
    type: String = "FC",
): String? {
    if (declaration !in content)
        return null

    var comment = content.substringBefore("\n$declaration")
    comment = if ("\n\n" in comment) {
        comment.substringAfterLast("\n\n")
    } else {
        comment.substringAfterLast("};\n")
    }

    if (comment.startsWith("export "))
        comment = comment
            .substringAfterLast(";\n")
            .substringAfterLast("}\n")

    return "$comment\n" +
            "@JsName(\"default\")\n" +
            "external val $name: react.$type<$propsName>"
}
