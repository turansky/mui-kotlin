// Automatically generated - do not modify!

@file:JsModule("@mui/material/ListSubheader")
@file:JsNonModule

package mui.material

external interface ListSubheaderProps : react.PropsWithChildren {
    /**
     * The content of the component.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: ListSubheaderClasses

    /**
     * The color of the component. It supports those theme colors that make sense for this component.
     * @default 'default'
     */
    var color: Union /* 'default' | 'primary' | 'inherit' */

    /**
     * If `true`, the List Subheader will not have gutters.
     * @default false
     */
    var disableGutters: Boolean

    /**
     * If `true`, the List Subheader will not stick to the top during scroll.
     * @default false
     */
    var disableSticky: Boolean

    /**
     * If `true`, the List Subheader is indented.
     * @default false
     */
    var inset: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Lists](https://material-ui.com/components/lists/)
 *
 * API:
 *
 * - [ListSubheader API](https://material-ui.com/api/list-subheader/)
 */
@JsName("default")
external val ListSubheader: react.FC<ListSubheaderProps>