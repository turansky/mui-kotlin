// Automatically generated - do not modify!

@file:JsModule("@mui/material/Typography")
@file:JsNonModule

package mui.material

external interface TypographyProps : react.PropsWithChildren {
    /**
     * Set the text-align on the component.
     * @default 'inherit'
     */
    var align: Union /* 'inherit' | 'left' | 'center' | 'right' | 'justify' */

    /**
     * The content of the component.
     */
    override var children: Array<out react.ReactNode>?

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: TypographyClasses

    /**
     * If `true`, the text will have a bottom margin.
     * @default false
     */
    var gutterBottom: Boolean

    /**
     * If `true`, the text will not wrap, but instead will truncate with a text overflow ellipsis.
     *
     * Note that text overflow can only happen with block or inline-block level elements
     * (the element needs to have a width in order to overflow).
     * @default false
     */
    var noWrap: Boolean

    /**
     * If `true`, the element will be a paragraph element.
     * @default false
     */
    var paragraph: Boolean

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * Applies the theme typography styles.
     * @default 'body1'
     */
    var variant: Union /* Variant | 'inherit', TypographyPropsVariantOverrides */

    /**
     * The component maps the variant prop to a range of different HTML element types.
     * For instance, subtitle1 to `<h6>`.
     * If you wish to change that mapping, you can provide your own.
     * Alternatively, you can use the `component` prop.
     * @default {
     *   h1: 'h1',
     *   h2: 'h2',
     *   h3: 'h3',
     *   h4: 'h4',
     *   h5: 'h5',
     *   h6: 'h6',
     *   subtitle1: 'h6',
     *   subtitle2: 'h6',
     *   body1: 'p',
     *   body2: 'p',
     *   inherit: 'p',
     * }
     */
    var variantMapping: dynamic
}

/**
 *
 * Demos:
 *
 * - [Breadcrumbs](https://material-ui.com/components/breadcrumbs/)
 * - [Typography](https://material-ui.com/components/typography/)
 *
 * API:
 *
 * - [Typography API](https://material-ui.com/api/typography/)
 */
@JsName("default")
external val Typography: react.FC<TypographyProps>