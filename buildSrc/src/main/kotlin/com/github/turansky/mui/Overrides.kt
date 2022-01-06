package com.github.turansky.mui

internal fun fixOverrides(
    name: String,
    content: String,
): String =
    when (name) {
        "Box",
        -> content
            .override("component")

        "ButtonBase",
        -> content
            .override("disabled")
            .override("tabIndex")

        "Button",
        "Fab",
        "IconButton",
        -> content
            .override("disabled")

        "ToggleButton",
        -> content
            .override("disabled")
            .override("value")

        "LoadingButton",
        -> content
            .override("classes")
            .override("sx")

        "SwipeableDrawer",
        -> content
            .override("onClose")
            .override("open")
            .replace("open: Boolean", "open: Boolean?")

        "TableCell",
        -> content
            .override("align")
            .override("scope")

        "TreeItemContent",
        "Collapse",
        -> content
            .override("className")

        "Dialog",
        "Drawer",
        "Popover",
        -> content
            .override("sx")

        "SpeedDial",
        -> content
            .override("hidden")

        "PopperUnstyled",
        -> content
            .override("children")

        "SliderUnstyled",
        -> content
            .override("defaultValue")
            .override("tabIndex")

        "TabUnstyled",
        -> content
            .override("components")
            .override("componentsProps")

        else -> content
    }

private fun String.override(
    name: String,
): String =
    replaceFirst("var $name:", "override var $name:")
