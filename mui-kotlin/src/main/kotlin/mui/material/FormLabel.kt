// Automatically generated - do not modify!

@file:JsModule("@mui/material/FormLabel")
@file:JsNonModule

package mui.material

external interface FormLabelProps : react.PropsWithChildren {
    /**
     * The content of the component.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: FormLabelClasses

    /**
     * The color of the component. It supports those theme colors that make sense for this component.
     */
    var color: Union /* 'primary' | 'secondary' | 'error' | 'info' | 'success' | 'warning', FormLabelPropsColorOverrides */

    /**
     * If `true`, the label should be displayed in a disabled state.
     */
    var disabled: Boolean

    /**
     * If `true`, the label is displayed in an error state.
     */
    var error: Boolean

    /**
     * If `true`, the label should use filled classes key.
     */
    var filled: Boolean

    /**
     * If `true`, the input of this label is focused (used by `FormGroup` components).
     */
    var focused: Boolean

    /**
     * If `true`, the label will indicate that the `input` is required.
     */
    var required: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Checkboxes](https://material-ui.com/components/checkboxes/)
 * - [Radio Buttons](https://material-ui.com/components/radio-buttons/)
 * - [Switches](https://material-ui.com/components/switches/)
 *
 * API:
 *
 * - [FormLabel API](https://material-ui.com/api/form-label/)
 */
@JsName("default")
external val FormLabel: react.FC<FormLabelProps>