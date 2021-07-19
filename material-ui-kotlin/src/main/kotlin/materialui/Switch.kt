// Automatically generated - do not modify!

@file:JsModule("@material-ui/core")
@file:JsNonModule

package materialui

external interface SwitchProps : react.RProps {
    /**
     * The icon to display when the component is checked.
     */
    var checkedIcon: dynamic

    /**
     * The color of the component. It supports those theme colors that make sense for this component.
     */
    var color: dynamic /* 'primary' | 'secondary' | 'default' */

    /**
     * If `true`, the switch will be disabled.
     */
    var disabled: Boolean

    /**
     * The icon to display when the component is unchecked.
     */
    var icon: dynamic

    /**
     * The size of the switch.
     * `small` is equivalent to the dense switch styling.
     */
    var size: dynamic /* 'small' | 'medium' */

    /**
     * The value of the component. The DOM API casts this to a string.
     * The browser uses "on" as the default value.
     */
    var value: dynamic
}

/**
 *
 * Demos:
 *
 * - [Switches](https://material-ui.com/components/switches/)
 * - [Transfer List](https://material-ui.com/components/transfer-list/)
 *
 * API:
 *
 * - [Switch API](https://material-ui.com/api/switch/)
 * - inherits [IconButton API](https://material-ui.com/api/icon-button/)
 */
@JsName("default")
external val Switch: react.FC<SwitchProps>
