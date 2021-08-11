// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/TabScrollButton")
@file:JsNonModule

package material

external interface TabScrollButtonProps : react.PropsWithChildren {
    /**
     * The content of the component.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: TabScrollButtonClasses

    /**
     * The direction the button should indicate.
     */
    var direction: Union /* 'left' | 'right' */

    /**
     * If `true`, the component is disabled.
     */
    var disabled: Boolean

    /**
     * The component orientation (layout flow direction).
     */
    var orientation: Union /* 'horizontal' | 'vertical' */

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Tabs](https://material-ui.com/components/tabs/)
 *
 * API:
 *
 * - [TabScrollButton API](https://material-ui.com/api/tab-scroll-button/)
 */
@JsName("default")
external val TabScrollButton: react.FC<TabScrollButtonProps>
