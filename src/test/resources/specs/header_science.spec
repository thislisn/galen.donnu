@import galen-extras/galen-extras-rules.gspec

@objects
    header                  css #page-container #main-header
        logo                css img
        menu                id  top-menu
            lang-item       css .lang-item
        menu-item-*         css #top-menu > .menu-item
        menu-with-submenu-* css #top-menu > .menu-item-has-children
        search              id  et_top_search
        ham                 css #et_mobile_nav_menu .mobile_menu_bar

@groups
    (menu-item, menu-items)                     header.menu-item-*
    (menu-with-submenu, menus-with-submenu)     header.menu-with-submenu-*

= Content =
    = header =
    @on *
        header:
             width 94 to 100% of screen/width

    @on desktop
        mobile-menu-icon:
            absent
        | amount of visible &menu-items should be 8
        | amount of visible &menus-with-submenu should be 6
        | header.logo should be located at the left inside header with ~33px margin
        | header.search should be located at the right inside header with ~30px margin
        | &menu-items are placed next to each other with ~ 3px margin
        header.logo:
             height 74px
             width 174px

    @on tablet
        | header.logo should be located at the left inside header with ~75px margin
        | header.search should be located at the right inside header with ~139px margin
        | header.ham should be located at the right inside header with ~72px margin

    @on mobile
        | header.logo should be located at the left inside header with ~51px margin
        | header.search should be located at the right inside header with ~116px margin
        | header.ham should be located at the right inside header with ~49px margin

    @on tablet, mobile
        header.logo:
             height 43px
             width 101px



