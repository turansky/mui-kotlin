// Automatically generated - do not modify!

@file:JsModule("@mui/material/Card")
@file:JsNonModule

package material

external interface CardProps : react.Props {
    /**
     * Override or extend the styles applied to the component.
     */
    var classes: CardClasses

    /**
     * If `true`, the card will use raised styling.
     * @default false
     */
    var raised: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Cards](https://material-ui.com/components/cards/)
 *
 * API:
 *
 * - [Card API](https://material-ui.com/api/card/)
 * - inherits [Paper API](https://material-ui.com/api/paper/)
 */

@JsName("default")
external val Card: react.FC<CardProps>
