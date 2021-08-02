// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/ImageList")
@file:JsNonModule

package material

external interface ImageListProps : react.RProps {
    /**
     * The content of the component, normally `ImageListItem`s.
     */
    var children: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: ImageListClasses

    /**
     * Number of columns.
     * @default 2
     */
    var cols: Number

    /**
     * The gap between items in px.
     * @default 4
     */
    var gap: Number

    /**
     * The height of one row in px.
     * @default 'auto'
     */
    var rowHeight: dynamic

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * The variant to use.
     * @default 'standard'
     */
    var variant: Union /* 'masonry' | 'quilted' | 'standard' | 'woven', ImageListPropsVariantOverrides */
}

/**
 *
 * Demos:
 *
 * - [Image List](https://material-ui.com/components/image-list/)
 *
 * API:
 *
 * - [ImageList API](https://material-ui.com/api/image-list/)
 */
@JsName("default")
external val ImageList: react.FC<ImageListProps>
