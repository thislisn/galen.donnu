
@import galen-extras/galen-extras-rules.gspec

@objects
    body                  id  et-boc
        about_donnu_block css div.et_pb_column.et_pb_specialty_column
            title         css h1.entry-title
            img           css img
            text-block-*  css div.et_pb_text_inner
        menu              css div.et_pb_column.et_pb_column_single
            search        id  searchform
            archive       css h4.widgettitle
            nav_menu      css .widget_nav_menu
            menu-item-*   css #menu-main-menu >.menu-item

@groups
    (text-block, text-blocks)  body.about_donnu_block.text-block-*
    (menu-item, menu-items)  body.menu.menu-item-*

= Content =
    @on *
      | amount of visible &text-blocks should be 2

    @on desktop
      | amount of visible &menu-items should be 7
      | &menu-items are placed above each other with ~ 7px margin
      body.menu.nav_menu:
        above body.menu.search ~ 46px
      body.menu.search:
        above body.menu.archive ~ 46px
      | &text-blocks are placed above each other with ~ 70px margin
      body.about_donnu_block.img:
        left-of body.about_donnu_block.text-block-1 ~ 54px
        height 331px
        width 341px
      body.about_donnu_block.title:
        above body.about_donnu_block.img ~ 54px

    @on tablet
      body.about_donnu_block.title:
        above body.about_donnu_block.img ~ 59px
      body.about_donnu_block.img:
        height 559px
        width 575px
      | &text-blocks are placed above each other with ~ 60px margin


    @on mobile


