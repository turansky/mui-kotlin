// Automatically generated - do not modify!

@file:JsModule("@mui/lab/PickersDay")
@file:JsNonModule

package mui.material

external interface PickersDayProps : react.Props {
    /**
     * If `true`, `onChange` is fired on click even if the same date is selected.
     * @default false
     */
    var allowSameDateSelection: Boolean

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * The date to show.
     */
    var day: dynamic

    /**
     * If `true`, renders as disabled.
     * @default false
     */
    var disabled: Boolean

    /**
     * If `true`, todays date is rendering without highlighting with circle.
     * @default false
     */
    var disableHighlightToday: Boolean

    /**
     * If `true`, days are rendering without margin. Useful for displaying linked range of days.
     * @default false
     */
    var disableMargin: Boolean

    var isAnimating: Boolean

    var onDayFocus: dynamic

    var onDaySelect: dynamic

    /**
     * If `true`, day is outside of month and will be hidden.
     */
    var outsideCurrentMonth: Boolean

    /**
     * If `true`, renders as selected.
     * @default false
     */
    var selected: Boolean

    /**
     * If `true`, days that have `outsideCurrentMonth={true}` are displayed.
     * @default false
     */
    var showDaysOutsideCurrentMonth: Boolean

    /**
     * If `true`, renders as today date.
     * @default false
     */
    var today: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}
