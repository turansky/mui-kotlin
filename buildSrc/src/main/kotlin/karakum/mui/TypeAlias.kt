package karakum.mui

private val ALIAS_MAP = mapOf(
    "FilledInputProps['onChange']" to "react.dom.events.ChangeEventHandler<web.html.HTMLElement>",
    "InputBaseProps['inputProps']" to "InputBaseComponentProps",
    "InputBaseProps['onBlur']" to "react.dom.events.FocusEventHandler<web.html.HTMLElement>",
    "InputProps['inputProps']" to "InputBaseComponentProps",
    "NativeSelectInputProps['onChange']" to "react.dom.events.ChangeEventHandler<*>",
    "OutlinedInputProps['onChange']" to "react.dom.events.ChangeEventHandler<web.html.HTMLElement>",
    "PaperProps['role']" to "react.dom.aria.AriaRole",
    "PopoverProps['anchorEl']" to "(element: Element) -> Element",
    "PopoverProps['classes']" to "PopoverClasses",
    "PopoverProps['onClose']" to "",
    "PortalProps['container']" to "Element",
    "PortalProps['disablePortal']" to "Boolean",
    "SelectInputProps<T>['onChange']" to "(event: react.dom.events.ChangeEvent<web.html.HTMLInputElement>, child: react.ReactNode) -> Unit",
    "SnackbarContentProps['action']" to "react.ReactNode",
    "SnackbarContentProps['message']" to "react.ReactNode",
    "StandardInputProps['onChange']" to "react.dom.events.ChangeEventHandler<web.html.HTMLElement>",
    "StandardInputProps['onFocus']" to "react.dom.events.FocusEventHandler<web.html.HTMLElement>",
    "StaticWrapperProps['displayStaticWrapperAs']" to "",
    "StyledGlobalStylesProps['styles']" to "",
    "SwitchBaseProps['checked']" to "Boolean",
    "SwitchBaseProps['disableRipple']" to "Boolean",
    "SwitchBaseProps['disabled']" to "Boolean",
    "SwitchBaseProps['id']" to "String",
    "SwitchBaseProps['inputProps']" to "react.dom.html.InputHTMLAttributes<web.html.HTMLInputElement>",
    "SwitchBaseProps['onChange']" to "(event: react.dom.events.ChangeEvent<web.html.HTMLInputElement>, checked: Boolean) -> Unit",
    "SwitchBaseProps['required']" to "Boolean",
    "SwitchBaseProps['value']" to "",
    "TableCellBaseProps['scope']" to "String",
    "TooltipProps['classes']" to "TooltipClasses",
    "TooltipProps['placement']" to "TooltipPlacement",
    "TransitionProps['easing']" to "",
    "TransitionProps['in']" to "",
    "TransitionProps['timeout']" to "",
    "TypographyProps['classes']" to "TypographyClasses",
    "TypographyProps['color']" to "",
    "TypographyProps['variant']" to "",
    "UsePaginationItem['type']" to "UsePaginationItemType",

    "FormLabelProps['color']" to "FormLabelColor",
    "PaginationProps['color']" to "PaginationColor",
    "PaginationProps['size']" to "Size",
    "PaginationProps['shape']" to "PaginationShape",
    "PaginationProps['variant']" to "PaginationVariant",

    "Options['modifiers']" to "ReadonlyArray<Modifier<*>>",

    "BackdropUnstyledTypeMap['props']['classes']" to "mui.base.BackdropUnstyledClasses",

    "ModalProps['onBackdropClick']" to "react.dom.events.ReactEventHandler<*>",
    "ModalProps['open']" to "Boolean",
    "ModalProps['container']" to "Element",
    "ModalProps['onClose']" to "(event: dynamic, reason: String) -> Unit",

    "SliderUnstyledTypeMap['props']['slotProps']" to "mui.base.SliderUnstyledOwnProps.SlotProps",
    "PopperUnstyledProps['slotProps']" to "mui.base.PopperUnstyledOwnProps.SlotProps",
    "ModalUnstyledTypeMap['props']['slotProps']" to "mui.base.ModalUnstyledOwnProps.SlotProps",
    "BadgeUnstyledTypeMap['props']['slotProps']" to "mui.base.BadgeUnstyledOwnProps.SlotProps",
)

internal fun String.toAlias(): String? =
    ALIAS_MAP[this]
        ?.takeIf { it.isNotEmpty() }
