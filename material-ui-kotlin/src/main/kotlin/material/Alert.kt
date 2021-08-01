// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/Alert")
@file:JsNonModule

package material

external interface AlertProps : react.RProps {
    /**
     * The action to display. It renders after the message, at the end of the alert.
     */
    var action: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * Override the default label for the *close popup* icon button.
     *
     * For localization purposes, you can use the provided [translations](/guides/localization/).
     * @default 'Close'
     */
    var closeText: String

    /**
     * The main color for the alert. Unless provided, the value is taken from the `severity` prop.
     */
    var color: dynamic

    /**
     * The severity of the alert. This defines the color and icon used.
     * @default 'success'
     */
    var severity: dynamic

    /**
     * Override the icon displayed before the children.
     * Unless provided, the icon is mapped to the value of the `severity` prop.
     */
    var icon: dynamic

    /**
     * The ARIA role attribute of the element.
     * @default 'alert'
     */
    var role: String

    /**
     * The component maps the `severity` prop to a range of different icons,
     * for instance success to `<SuccessOutlined>`.
     * If you wish to change this mapping, you can provide your own.
     * Alternatively, you can use the `icon` prop to override the icon displayed.
     */
    var iconMapping: dynamic

    /**
     * Callback fired when the component requests to be closed.
     * When provided and no `action` prop is set, a close icon button is displayed that triggers the callback when clicked.
     * @param {React.SyntheticEvent} event The event source of the callback.
     */
    var onClose: dynamic

    /**
     * The variant to use.
     * @default 'standard'
     */
    var variant: dynamic

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Alert](https://material-ui.com/components/alert/)
 *
 * API:
 *
 * - [Alert API](https://material-ui.com/api/alert/)
 * - inherits [Paper API](https://material-ui.com/api/paper/)
 */
@JsName("default")
external val Alert: react.FC<AlertProps>