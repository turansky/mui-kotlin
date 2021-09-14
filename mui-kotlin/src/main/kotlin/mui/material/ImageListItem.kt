// Automatically generated - do not modify!

@file:JsModule("@mui/material/ImageListItem")
@file:JsNonModule

package mui.material

external interface ImageListItemProps : react.PropsWithChildren {
    /**
     * The content of the component, normally an `<img>`.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: ImageListItemClasses

    /**
     * Width of the item in number of grid columns.
     * @default 1
     */
    var cols: Number

    /**
     * Height of the item in number of grid rows.
     * @default 1
     */
    var rows: Number

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Image List](https://material-ui.com/components/image-list/)
 *
 * API:
 *
 * - [ImageListItem API](https://material-ui.com/api/image-list-item/)
 */
@JsName("default")
external val ImageListItem: react.FC<ImageListItemProps>