// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/Avatar")
@file:JsNonModule

package material

external interface AvatarProps : react.RProps {
    /**
     * Used in combination with `src` or `srcSet` to
     * provide an alt attribute for the rendered `img` element.
     */
    var alt: String

    /**
     * Used to render icon or text elements inside the Avatar if `src` is not set.
     * This can be an element, or just a string.
     */
    var children: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#Attributes">Attributes</a> applied to the `img` element if the component is used to display an image.
     * It can be used to listen for the loading error event.
     */
    var imgProps: dynamic

    /**
     * The `sizes` attribute for the `img` element.
     */
    var sizes: String

    /**
     * The `src` attribute for the `img` element.
     */
    var src: String

    /**
     * The `srcSet` attribute for the `img` element.
     * Use this attribute for responsive image display.
     */
    var srcSet: String

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * The shape of the avatar.
     * @default 'circular'
     */
    var variant: dynamic
}

/**
 *
 * Demos:
 *
 * - [Avatars](https://material-ui.com/components/avatars/)
 *
 * API:
 *
 * - [Avatar API](https://material-ui.com/api/avatar/)
 */
@JsName("default")
external val Avatar: react.FC<AvatarProps>