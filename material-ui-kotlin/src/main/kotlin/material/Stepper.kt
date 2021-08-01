// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/Stepper")
@file:JsNonModule

package material

external interface StepperProps : react.RProps {
    /**
     * Set the active step (zero based index).
     * Set to -1 to disable all the steps.
     * @default 0
     */
    var activeStep: Number

    /**
     * If set to 'true' and orientation is horizontal,
     * then the step label will be positioned under the icon.
     * @default false
     */
    var alternativeLabel: Boolean

    /**
     * Two or more `<Step />` components.
     */
    var children: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * An element to be placed between each step.
     * @default <StepConnector />
     */
    var connector: dynamic

    /**
     * If set the `Stepper` will not assist in controlling steps for linear flow.
     * @default false
     */
    var nonLinear: Boolean

    /**
     * The component orientation (layout flow direction).
     * @default 'horizontal'
     */
    var orientation: dynamic

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Steppers](https://material-ui.com/components/steppers/)
 *
 * API:
 *
 * - [Stepper API](https://material-ui.com/api/stepper/)
 */
@JsName("default")
external val Stepper: react.FC<StepperProps>