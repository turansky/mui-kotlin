// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/ImageListItemBar")
@file:JsNonModule

package material

external interface ImageListItemBarProps : react.RProps {
    /**
     * An IconButton element to be used as secondary action target
     * (primary action target is the item itself).
     */
    var actionIcon: react.ReactNode

    /**
     * Position of secondary action IconButton.
     * @default 'right'
     */
    var actionPosition: dynamic /* 'left' | 'right' */

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * Position of the title bar.
     * @default 'bottom'
     */
    var position: dynamic /* 'below' | 'top' | 'bottom' */

    /**
     * String or element serving as subtitle (support text).
     */
    var subtitle: react.ReactNode

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * Title to be displayed.
     */
    var title: react.ReactNode
}

/**
 *
 * Demos:
 *
 * - [Image List](https://material-ui.com/components/image-list/)
 *
 * API:
 *
 * - [ImageListItemBar API](https://material-ui.com/api/image-list-item-bar/)
 */
@JsName("default")
external val ImageListItemBar: react.FC<ImageListItemBarProps>