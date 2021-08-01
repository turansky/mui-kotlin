// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/Tab")
@file:JsNonModule

package material

external interface TabProps : react.RProps {
    /**
     * This prop isn't supported.
     * Use the `component` prop if you need to change the children structure.
     */
    var children: dynamic

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * If `true`, the component is disabled.
     * @default false
     */
    var disabled: Boolean

    /**
     * If `true`, the  keyboard focus ripple is disabled.
     * @default false
     */
    var disableFocusRipple: Boolean

    /**
     * The icon to display.
     */
    var icon: dynamic

    /**
     * The label element.
     */
    var label: react.ReactNode

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * You can provide your own value. Otherwise, we fallback to the child position index.
     */
    var value: Any

    /**
     * Tab labels appear in a single row.
     * They can use a second line if needed.
     * @default false
     */
    var wrapped: Boolean
}

/**
 *
 * Demos:
 *
 * - [Tabs](https://material-ui.com/components/tabs/)
 *
 * API:
 *
 * - [Tab API](https://material-ui.com/api/tab/)
 * - inherits [ButtonBase API](https://material-ui.com/api/button-base/)
 */
@JsName("default")
external val Tab: react.FC<TabProps>