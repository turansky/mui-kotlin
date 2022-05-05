package karakum.mui

import java.io.File

private const val GENERATOR_COMMENT = "Automatically generated - do not modify!"

private val DEFAULT_IMPORTS = listOf(
    "Promise" to "kotlin.js.Promise",

    "ReadonlyArray" to "kotlinx.js.ReadonlyArray",
    "Record<" to "kotlinx.js.Record",
    "Void" to "kotlinx.js.Void",

    " ClassName" to "csstype.ClassName",
)

// language=Kotlin
private val TYPES_PROPS_WITH_COMPONENT = """
external interface PropsWithComponent : react.Props {
    var component: react.ElementType<*>?
}
""".trimIndent()

// language=Kotlin
private val SYSTEM_ALIASES = """
typealias Union = String
""".trimIndent()

// language=Kotlin
private val SYSTEM_SX_PROPS = """
@Suppress("UNUSED_TYPEALIAS_PARAMETER")
typealias SxProps<T> = react.CSSProperties
""".trimIndent()

// language=Kotlin
private val SYSTEM_PROPS_WITH_SX = """
import react.Props    
    
external interface PropsWithSx : Props {
    var sx: SxProps<Theme>?
}
""".trimIndent()

// language=Kotlin
private val SYSTEM_SX = """
import csstype.PropertiesBuilder
import kotlinx.js.jso

inline fun PropsWithSx.sx(
    crossinline block: PropertiesBuilder.() -> Unit,
) {
    sx = jso(block)
}
""".trimIndent()

// language=Kotlin
private val SYSTEM_RESPONSIVE_STYLE_VALUE = """
external interface ResponsiveStyleValue<T : Any>

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Any> responsive(
    value: T,
): ResponsiveStyleValue<T> =
    value.unsafeCast<ResponsiveStyleValue<T>>()

@Suppress("BOUNDS_NOT_ALLOWED_IF_BOUNDED_BY_TYPE_PARAMETER")
fun <T : Any, R> responsive(
    vararg values: Pair<Breakpoint, T>,
): R where R : T,
           R : ResponsiveStyleValue<T> =
    Record<Breakpoint, T> {
        for ((key, value) in values) {
            set(key, value)
        }
    }.unsafeCast<R>()
""".trimIndent()

// language=Kotlin
private val SYSTEM_STANDARD_PROPS = """
external interface StandardProps: 
    react.PropsWithStyle,
    react.PropsWithClassName
""".trimIndent()

private val SYSTEM_BREAKPOINT = convertUnion("Breakpoint = 'xs' | 'sm' | 'md' | 'lg' | 'xl'")!!

// language=Kotlin
private val SYSTEM_SHAPE = """
external interface Shape {
    var borderRadius: csstype.BorderRadius
}

typealias ShapeOptions = Shape
""".trimIndent()

private val MATERIAL_PALETTE_MODE = convertUnion("PaletteMode = 'light' | 'dark'")!!

// language=Kotlin
private val STYLE_TRANSITION_CREATE_OPTIONS = """
external interface TransitionCreateOptions {
    var duration: Number?
    var easing: String?
    var delay: Number?    
}
""".trimIndent()

// language=Kotlin
private val MATERIAL_SIZE = """
@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
// language=JavaScript
@JsName("(/*union*/{small: 'small', medium: 'medium', large: 'large'}/*union*/)")
sealed external interface Size {
    object small : Size, BaseSize
    object medium : Size, BaseSize
    object large : Size
}

sealed external interface BaseSize
""".trimIndent()

// language=Kotlin
private val TRANSITIONS_STUBS = """
external interface TransitionProps: react.Props
""".trimIndent()

// language=Kotlin
private val PICKERS_STUBS = """
typealias PickerSelectionState = String

typealias PickerOnChangeFn<TDate> = (
    date: TDate?, 
    selectionState: PickerSelectionState?,
) -> Unit
""".trimIndent()

private val CALENDAR_PICKER_VIEW = convertUnion("CalendarPickerView = 'year' | 'day' | 'month'")!!
private val CLOCK_PICKER_VIEW = convertUnion("ClockPickerView = 'hours' | 'minutes' | 'seconds'")!!

private val BASE_TYPES = setOf(
    "ClickAwayListener",
    "NoSsr",
    "Portal",
    "TextareaAutosize",
)

private val EXCLUDED_TYPES = setOf(
    "CalendarPicker",
    "CalendarPickerSkeleton",
    "ClockPicker",
    "DatePicker",
    "DateTimePicker",
    "DesktopDatePicker",
    "DesktopDateTimePicker",
    "DesktopTimePicker",
    "LocalizationProvider",
    "MobileDatePicker",
    "MobileDateTimePicker",
    "MobileTimePicker",
    "MonthPicker",
    "PickersDay",
    "StaticDatePicker",
    "StaticDateTimePicker",
    "StaticTimePicker",
    "TimePicker",
    "YearPicker",

    "DateRangePicker",
    "DateRangePickerDay",
    "DesktopDateRangePicker",
    "MobileDateRangePicker",
    "StaticDateRangePicker",

    // TODO: fix
    "Timeline"
)

private enum class Package(
    id: String? = null,
    pkg: String? = null,
) {
    types,
    base,
    material,
    materialStyles("material/styles"),
    materialTransitions,
    iconsMaterial("icons-material"),
    system,
    pickers("x-date-pickers", "muix.pickers"),
    grid("x-data-grid", "muix.grid"),
    lab,

    ;

    val id = id ?: name

    val pkg: String = pkg ?: ("mui." + name.replace(Regex("""[A-Z]""")) { "." + it.value.toLowerCase() })
}

fun generateKotlinDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    generateTypesDeclarations(sourceDir)
    generateBaseDeclarations(typesDir.resolve("base"), sourceDir)
    generateSystemDeclarations(typesDir.resolve("system"), sourceDir)
    generateMaterialDeclarations(typesDir.resolve("material"), sourceDir)
    generateStylesDeclarations(typesDir.resolve("material/styles"), sourceDir)
    generateTransitionsDeclarations(sourceDir)
    generateLabDeclarations(typesDir.resolve("lab"), sourceDir)
    generatePickersDeclarations(typesDir.resolve("x-date-pickers"), sourceDir)
}

fun generateKotlinIconsDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    generateIconsMaterialDeclarations(typesDir.resolve("icons-material"), sourceDir)
}

fun generateKotlinDataGridDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    generateDataGridDeclarations(typesDir.resolve("x-data-grid"), sourceDir)
}

private fun generateTypesDeclarations(
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/types")
        .also { it.mkdirs() }

    targetDir.resolve("PropsWithComponent.kt")
        .writeText(fileContent(body = TYPES_PROPS_WITH_COMPONENT, pkg = Package.types))
}

private fun generateBaseDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/base")
        .also { it.mkdirs() }

    val directories = typesDir.listFiles { file -> file.isDirectory } ?: return

    directories.asSequence()
        .filter { it.name.isComponentName() }
        .filter { it.name != "ListboxUnstyled" }
        .map {
            var name = it.name
            if (name == "AutocompleteUnstyled")
                name = "useAutocomplete"

            it.resolve("$name.d.ts")
        }
        .flatMap { component ->
            val dir = component.parentFile

            val hooks = if (dir.name == "SwitchUnstyled") {
                sequenceOf(dir.resolve("use" + dir.name.removeSuffix("Unstyled") + ".d.ts"))
            } else emptySequence()

            dir.existed(
                dir.name + "Props.d.ts",
                dir.name + ".types.d.ts",
                "use" + dir.name.removeSuffix("Unstyled") + "Props.d.ts",
                "use" + dir.name.removeSuffix("Unstyled") + ".types.d.ts",
                "Use" + dir.name.removeSuffix("Unstyled") + "Props.d.ts",
            ) + hooks + component
        }
        .forEach { generate(it, targetDir, Package.base) }
}

private fun generateSystemDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/system")
        .also { it.mkdirs() }

    val directories = typesDir.listFiles { file -> file.isDirectory } ?: return

    directories.asSequence()
        .filter { it.name.isComponentName() }
        .map { it.resolve("${it.name}.d.ts") }
        .forEach { generate(it, targetDir, Package.system) }

    typesDir.resolve("createTheme")
        .listFiles { file -> file.name.startsWith("create") && file.name.endsWith(".d.ts") }!!
        .forEach { generate(it, targetDir, Package.system) }

    generate(typesDir.resolve("useTheme.d.ts"), targetDir, Package.system)

    sequenceOf(
        "Breakpoint" to SYSTEM_BREAKPOINT,
        "shape" to SYSTEM_SHAPE,

        "Aliases" to SYSTEM_ALIASES,

        "SxProps" to SYSTEM_SX_PROPS,
        "PropsWithSx" to SYSTEM_PROPS_WITH_SX,
        "sx" to SYSTEM_SX,

        "ResponsiveStyleValue" to SYSTEM_RESPONSIVE_STYLE_VALUE,
        "StandardProps" to SYSTEM_STANDARD_PROPS,
    ).forEach { (name, body) ->
        targetDir.resolve("$name.kt")
            .writeText(fileContent(body = body, pkg = Package.system))
    }
}

private fun generateMaterialDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/material")
        .also { it.mkdirs() }

    val directories = typesDir.listFiles { file -> file.isDirectory } ?: return

    directories.asSequence()
        .filter { it.name.isComponentName() || it.name == "internal" || it.name == "useMediaQuery" || it.name == "usePagination" }
        .filter { it.name !in BASE_TYPES }
        .filter { it.name != "StyledEngineProvider" }
        .onEach {
            when (it.name) {
                "ButtonBase" -> {
                    val file = it.resolve("TouchRipple.d.ts")
                    generate(file, targetDir, Package.material, true)
                }

                "TablePagination" -> {
                    val file = it.resolve("${it.name}Actions.d.ts")
                    generate(file, targetDir, Package.material, true)
                }
            }
        }
        .map {
            val fileName = when (it.name) {
                "internal" -> "SwitchBase.d.ts"
                else -> "${it.name}.d.ts"
            }
            it.resolve(fileName)
        }
        .forEach { generate(it, targetDir, Package.material) }

    sequenceOf(
        MUI to MUI_BODY,
        "PaletteMode" to MATERIAL_PALETTE_MODE,
        "Size" to MATERIAL_SIZE,
    ).forEach { (name, body) ->
        val annotations = if (name == MUI) {
            "@file:Suppress(\n\"NESTED_CLASS_IN_EXTERNAL_INTERFACE\",\n)"
        } else ""

        targetDir.resolve("$name.kt")
            .writeText(fileContent(annotations, body, Package.material))
    }
}

private fun generateStylesDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/material/styles")
        .also { it.mkdirs() }

    fun isStyleDefinition(fileName: String): Boolean {
        val name = fileName.removeSuffix(".d.ts")
            .takeIf { it != fileName }
            ?: return false

        if (name.startsWith("create"))
            return true

        return when (name) {
            "ThemeProvider",
            "useTheme",
            "zIndex",
            -> true

            else -> false
        }
    }

    typesDir.listFiles { file -> isStyleDefinition(file.name) }!!
        .forEach { generate(it, targetDir, Package.materialStyles) }
}


private fun generateTransitionsDeclarations(
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/material/transitions")
        .also { it.mkdirs() }

    targetDir.resolve("Stubs.kt")
        .writeText(fileContent(body = TRANSITIONS_STUBS, pkg = Package.materialTransitions))
}

private fun generateIconsMaterialDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/icons/material")
        .also { it.mkdirs() }

    for ((name, body) in convertIcons(typesDir.resolve("index.d.ts"))) {
        val annotations = if (name != "SvgIconComponent") {
            moduleDeclaration(Package.iconsMaterial, null, name)
        } else ""

        targetDir.resolve("$name.kt")
            .writeText(fileContent(annotations, body, Package.iconsMaterial))
    }
}

private fun generateDataGridDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("muix/grid")
        .also { it.mkdirs() }

    // TODO: implement
}

private fun generateLabDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("mui/lab")
        .also { it.mkdirs() }

    val directories = typesDir.listFiles { file -> file.isDirectory } ?: return

    directories.asSequence()
        .filter { !it.name.startsWith("Adapter") }
        .filter { it.name !in EXCLUDED_TYPES }
        .filter { it.name.isComponentName() }
        .filter { !it.resolve("${it.name}.d.ts").readText().startsWith("export { default } from ") }
        .onEach {
            when (it.name) {
                "TreeItem" -> {
                    val file = it.resolve("${it.name}Content.d.ts")
                    generate(file, targetDir, Package.lab)
                }
            }
        }
        .map { it.resolve("${it.name}.d.ts") }
        .forEach { generate(it, targetDir, Package.lab) }
}

private fun generatePickersDeclarations(
    typesDir: File,
    sourceDir: File,
) {
    val targetDir = sourceDir.resolve("muix/pickers")
        .also { it.mkdirs() }

    val directories = typesDir.listFiles { file -> file.isDirectory } ?: return

    directories.asSequence()
        .filter { !it.name.startsWith("Adapter") }
        .filter { it.name.isComponentName() }
        .map { it.resolve("${it.name}.d.ts") }
        .forEach { generate(it, targetDir, Package.pickers) }

    sequenceOf(
        "Stubs" to PICKERS_STUBS,
        "CalendarPickerView" to CALENDAR_PICKER_VIEW,
        "ClockPickerView" to CLOCK_PICKER_VIEW,
    ).forEach { (name, body) ->
        targetDir.resolve("$name.kt")
            .writeText(fileContent(body = body, pkg = Package.pickers))
    }
}

private fun String.isComponentName(): Boolean {
    if ("_" in this)
        return false

    val char = get(0)
    return char == char.toUpperCase() && char != char.toLowerCase()
}

private fun moduleDeclaration(
    pkg: Package,
    subpackage: String?,
    componentName: String,
): String {
    val moduleName = sequenceOf(
        "@mui",
        pkg.id,
        subpackage,
        componentName,
    ).filterNotNull()
        .joinToString("/")

    return "@file:JsModule(\"$moduleName\")\n@file:JsNonModule"
}


private fun generate(
    definitionFile: File,
    targetDir: File,
    pkg: Package,
    fullPath: Boolean = false,
) {
    val componentName = when (definitionFile.name) {
        "shared.d.ts" -> "CalendarPickerView"
        else -> definitionFile.name.removeSuffix(".d.ts")
    }
    val (body, extensions) = convertDefinitions(definitionFile)

    val subpackage = when {
        pkg == Package.materialStyles
        -> null

        fullPath || componentName == "SwitchBase" || componentName == "useAutocomplete" || componentName == "useSwitch" || componentName.startsWith(
            "create")
        -> definitionFile.parentFile.name

        else -> null
    }

    val annotations = mutableListOf<String>()
    if ("external val " in body || "external fun " in body)
        annotations += moduleDeclaration(pkg, subpackage, componentName)

    if (componentName == "TextField")
        annotations += "@file:Suppress(\n" +
                "\"VIRTUAL_MEMBER_HIDDEN\",\n" +
                "\"NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE\",\n" +
                ")"

    if (componentName in OVERRIDE_FIX_REQUIRED)
        annotations += "@file:Suppress(\n\"VIRTUAL_MEMBER_HIDDEN\",\n)"

    if (componentName != "CalendarPickerView" && componentName != "createTypography") {
        val finalBody = when {
            componentName == "createTransitions" -> body + "\n\n" + STYLE_TRANSITION_CREATE_OPTIONS
            pkg == Package.pickers -> body.replace(JS_NAME_DEFAULT, "")
            else -> body
        }

        targetDir.resolve("$componentName.kt")
            .writeText(fileContent(annotations.joinToString("\n\n"), finalBody, pkg))
    }

    if (extensions.isNotEmpty()) {
        val fileName = when (componentName) {
            "Stepper" -> "Orientation"
            else -> "$componentName.ext"
        }

        val extensionsAnnotations = if ("inline fun " in extensions) {
            "@file:Suppress(\n" +
                    "\"DECLARATION_CANT_BE_INLINED\",\n" +
                    "\"NOTHING_TO_INLINE\",\n" +
                    ")"
        } else ""

        val finalBody = when (componentName) {
            "createTypography" -> extensions.replaceFirst("Variant", "TypographyVariant")
            else -> extensions
        }

        targetDir.resolve("$fileName.kt")
            .writeText(fileContent(annotations = extensionsAnnotations, body = finalBody, pkg = pkg))
    }

    val classesName = componentName + "Classes"
    val classesFile = definitionFile.parentFile.resolve(classesName.decapitalize() + ".d.ts")
    if (classesFile.exists()) {
        val (classes, mui) = convertClasses(componentName, classesFile)

        targetDir.resolve("$componentName.classes.kt")
            .writeText(fileContent(body = classes, pkg = pkg))

        if (mui != null) {
            val muiAnnotations = "@file:Suppress(\n\"NESTED_CLASS_IN_EXTERNAL_INTERFACE\",\n)"
            targetDir.resolve("$componentName.mui.kt")
                .writeText(fileContent(annotations = muiAnnotations, body = mui, pkg = pkg))
        }
    }
}

private fun fileContent(
    annotations: String = "",
    body: String,
    pkg: Package,
): String {
    val defaultImports = DEFAULT_IMPORTS
        .filter { it.first in body }
        .map { it.second }
        .plus(systemImports(body, pkg))
        .map { "import $it" }
        .joinToString("\n")

    return sequenceOf(
        "// $GENERATOR_COMMENT",
        annotations,
        "package ${pkg.pkg}",
        defaultImports,
        body,
    ).filter { it.isNotEmpty() }
        .joinToString("\n\n")
        .removeSuffix("\n") + "\n"
}

private fun systemImports(
    body: String,
    pkg: Package,
): Sequence<String> =
    if ("SxProps<Theme>" in body && pkg != Package.system) {
        sequenceOf(
            "mui.material.styles.Theme",
            "mui.system.SxProps",
        )
    } else emptySequence()
