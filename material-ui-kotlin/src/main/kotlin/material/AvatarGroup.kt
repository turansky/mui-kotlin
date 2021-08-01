// Automatically generated - do not modify!

@file:JsModule("@material-ui/core/AvatarGroup")
@file:JsNonModule

package material

external interface AvatarGroupProps : react.RProps {
    /**
     * The avatars to stack.
     */
    var children: react.ReactNode

    /**
     * Override or extend the styles applied to the component.
     */
    var classes: dynamic

    /**
     * Max avatars to show before +x.
     * @default 5
     */
    var max: Number

    /**
     * Spacing between avatars.
     * @default 'medium'
     */
    var spacing: dynamic /* 'small' | 'medium' | number */

    /**
     * The system prop that allows defining system overrides as well as additional CSS styles.
     */
    var sx: SxProps<Theme>

    /**
     * The variant to use.
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
 * - [AvatarGroup API](https://material-ui.com/api/avatar-group/)
 */
@JsName("default")
external val AvatarGroup: react.FC<AvatarGroupProps>