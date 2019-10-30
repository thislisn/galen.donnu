@import galen-extras/galen-extras-rules.gspec

@objects
    header              header.site-header.main-header
        ham             .ham
        donnu-logo      .logo-main
        menu            .menu
            lang-logo-* .lang-item
        menu-item-*     .menu > .menu-item

@groups
    (menu-item, menu-items)  header.menu-item-*
    (lang-logo, lang-logos)  header.menu.lang-logo-*

= Content =
    = header =
    @on *
        header:
             width 94 to 100% of screen/width
        | header.ham should be visible on mobile, tablet but absent on desktop
        header.donnu-logo:
            | squared with ~ 69px size

    @on desktop
        | amount of visible &menu-items should be 13
        | amount of visible &lang-logos should be 2
        | &lang-logos are placed above each other with ~ 52px margin
        header.menu:
            inside header ~ 15px top, ~ 166px left
        @for [1 - 5] as index
                header.menu-item-${index}:
                    above header.menu-item-${index + 5} ~ 0px
        @for [1 - 4, 6 - 9] as index
                header.menu-item-${index}:
                    left-of header.menu-item-${index + 1} ~ 0px

    @on tablet
        | header.ham should be located at the right inside header with ~69px margin
        | header.donnu-logo should be located at the left inside header with ~57px margin

    @on mobile
        | header.ham should be located at the right inside header with ~50px margin
        | header.donnu-logo should be located at the left inside header with ~38px margin


