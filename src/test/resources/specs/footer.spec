@import galen-extras/galen-extras-rules.gspec

@objects
    footer                     footer#footer
        widgets                .footer-widgets
             widget-title-*    .widgettitle
             nav-widget-*      .widget_nav_menu
             text-widget       .textwidget
                img            img
                text           p
        bottom                 .footer-bottom
            social             .social-networks
                logo-*         i
                name-*         span
            copyrights         .copyrights p

@groups
    (widget-title, widget-titles)       footer.widgets.widget-title-*

= Content =
    = footer =

     @on *
        footer:
             width 94 to 100% of screen/width
        footer.bottom, footer.widgets:
             centered horizontally inside footer
        footer.widgets.text-widget.img:
             height 119px
             width  127px
        footer.bottom.copyrights:
            text matches ".* Донецький національний університет імені Василя Стуса"

        = bottom =

    @on desktop
        footer.bottom.social:
            inside footer.bottom ~ 30px top, ~ 31px right
        footer.bottom.copyrights:
            left-of footer.bottom.social ~ 0px
            inside footer.bottom ~ 42px top, ~ 35px left

    @on tablet, mobile
        footer.bottom.social:
            centered horizontally inside footer.bottom
        footer.bottom.copyrights:
            below footer.bottom.social ~ 20px

        = widgets =

    @on desktop
        footer.widgets.text-widget.img, footer.widgets.text-widget.text:
            centered horizontally inside footer.widgets
        @for [1 - 2] as index
            footer.widgets.widget-title-${index}:
                 left-of footer.widgets.text-widget.img
        @for [3 - 4] as index
            footer.widgets.widget-title-${index}:
                 right-of footer.widgets.text-widget.img

    @on tablet, mobile
        footer.widgets.text-widget.img:
            inside footer.widgets ~ 315px top, ~ 0px left
        | &widget-titles are placed above each other with 131 to 392px margin

