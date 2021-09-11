// Automatically generated - do not modify!

@file:JsModule("@mui/material/OutlinedInput")
@file:JsNonModule

package material

external interface OutlinedInputProps : react.Props {
    /**
     * Override or extend the styles applied to the component.
     */
    var classes: OutlinedInputClasses

    /**
     * The label of the `input`. It is only used for layout. The actual labelling
     * is handled by `InputLabel`.
     */
    var label: react.ReactNode

    /**
     * If `true`, the outline is notched to accommodate the label.
     */
    var notched: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Text Fields](https://material-ui.com/components/text-fields/)
 *
 * API:
 *
 * - [OutlinedInput API](https://material-ui.com/api/outlined-input/)
 * - inherits [InputBase API](https://material-ui.com/api/input-base/)
 */
@JsName("default")
external val OutlinedInput: react.FC<OutlinedInputProps>
