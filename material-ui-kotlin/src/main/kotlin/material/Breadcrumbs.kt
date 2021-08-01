// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/Breadcrumbs")
@file:JsNonModule

package material

external interface BreadcrumbsProps : react.RProps {
    /**
     * The content of the component.
     */
    var children: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * Override the default label for the expand button.
     *
     * For localization purposes, you can use the provided [translations](/guides/localization/).
     * @default 'Show path'
     */
    var expandText: String

    /**
     * If max items is exceeded, the number of items to show after the ellipsis.
     * @default 1
     */
    var itemsAfterCollapse: Number

    /**
     * If max items is exceeded, the number of items to show before the ellipsis.
     * @default 1
     */
    var itemsBeforeCollapse: Number

    /**
     * Specifies the maximum number of breadcrumbs to display. When there are more
     * than the maximum number, only the first `itemsBeforeCollapse` and last `itemsAfterCollapse`
     * will be shown, with an ellipsis in between.
     * @default 8
     */
    var maxItems: Number

    /**
     * Custom separator node.
     * @default '/'
     */
    var separator: react.ReactNode

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>
}

/**
 *
 * Demos:
 *
 * - [Breadcrumbs](https://material-ui.com/components/breadcrumbs/)
 *
 * API:
 *
 * - [Breadcrumbs API](https://material-ui.com/api/breadcrumbs/)
 */
@JsName("default")
external val Breadcrumbs: react.FC<BreadcrumbsProps>