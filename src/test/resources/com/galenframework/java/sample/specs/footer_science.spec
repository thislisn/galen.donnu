@import galen-extras/galen-extras-rules.gspec
@import common.spec

@objects
    footer                 css   footer#main-footer
        info               id    footer-info
            info-block-*   css   .footer-custom-info
            copyright      css   .footer-custom-info #copyright div
            info-text-*    css   .footer-custom-info-simple

@groups
    (info-block, info-blocks)     footer.info.info-block-*
    (info-text, info-texts)       footer.info.info-text-*

= Content =
    = footer =

     @on *
        footer:
             width 94 to 100% of screen/width
        footer.info:
             centered horizontally inside footer
        | amount of visible &info-blocks should be 2
        | amount of visible &info-texts should be 3

    @on desktop
        | footer.info.info-block-1 should be located at the left inside footer.info with ${no_margin}
        | footer.info.info-block-2 should be located at the right inside footer.info with ${no_margin}


    @on tablet, mobile
        | &info-blocks are placed above each other with ${no_margin}

