// Automatically generated - do not modify!

@file:JsModule("@mui/material/Stack")
@file:JsNonModule

package material

external interface StackProps : react.PropsWithChildren {
    var ref: react.Ref<*>

    /**
     * The content of the component.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Defines the `flex-direction` style property.
     * It is applied for all screen sizes.
     * @default 'column'
     */
    var direction: ResponsiveStyleValue<Union /* 'row' | 'row-reverse' | 'column' | 'column-reverse' */>

    /**
     * Defines the space between immediate children.
     * @default 0
     */
    var spacing: ResponsiveStyleValue<dynamic>

    /**
     * Add an element between each child.
     */
    var divider: react.ReactNode

    /**
     * The system prop, which allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Stack](https://material-ui.com/components/stack/)
 *
 * API:
 *
 * - [Stack API](https://material-ui.com/api/stack/)
 */
@JsName("default")
external val Stack: react.FC<StackProps>
