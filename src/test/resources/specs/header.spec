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
            centered horizontally inside screen
        header.donnu-logo:
            width 69px
            height 69px

    @on desktop
        | amount of visible &menu-items should be 13
        | amount of visible &lang-logos should be 2
        header.menu:
            inside header ~ 15px top, ~ 166px left
        @forEach [header.menu.lang.logo-*] as itemName, next as nextItem
                ${itemName}:
                    above ${nextItem} ~ 52px
        @for [1 - 5] as index
                header.menu-item-${index}:
                    above header.menu-item-${index + 5} ~ 0px
        @for [1 - 4, 6 - 9] as index
                header.menu-item-${index}:
                    left-of header.menu-item-${index + 1} ~ 0px
        header.ham:
            absent


    @on tablet
        header.ham:
            inside header ~ 48px top, ~ 69px right
        header.donnu-logo:
            inside header ~ 15px top, ~ 57px left

    @on mobile
        header.ham:
            inside header ~ 48px top, ~ 50px right
        header.donnu-logo:
            inside header ~ 15px top, ~ 38px left


