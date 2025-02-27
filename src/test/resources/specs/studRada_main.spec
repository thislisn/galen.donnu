@import header_main.spec
@import footer_main.spec
@import galen-extras/galen-extras-rules.gspec

@objects
    stud-rada-slide    xpath    //rs-slide
        img            css      img
        text           xpath    //rs-layer-wrap[@class='rs-parallax-wrap']//rs-layer
    team               xpath    //section[@class='vc_cta3-container']/ancestor::div[@class='vc-row-container container']
        box-*          css      section.vc_cta3-container
        column-*       css      .wpb_column.vc_col-sm-12 div.wpb_column.vc_col-sm-4

@groups
    (box, boxes)       team.box-*
    (column, columns)  team.column-*

= Content =
    = studrada =
    @on *
        stud-rada-slide:
            width 94 to 100% of screen/width
            aligned vertically all header

    @on desktop
        stud-rada-slide.img:
            inside stud-rada-slide ~ 100px top, ~ 55px right
        stud-rada-slide.text:
            inside stud-rada-slide ~ 225px top, ~ 53px left
        stud-rada-slide:
            image file ${dumps_dm}\stud-rada-slide.png, error 2%, tolerance 80, ignore-objects stud-rada-slide.text, stretch, map-filter denoise 2

    @on tablet
        stud-rada-slide.img:
            inside stud-rada-slide ~ 92px top, ~ 1px right
        stud-rada-slide.text:
            inside stud-rada-slide ~ 248px top, ~ 17px left

    @on mobile
        stud-rada-slide.img:
            inside stud-rada-slide ~ 62px top, ~ 1px right
        stud-rada-slide.text:
            inside stud-rada-slide ~ 166px top, ~ 11px left

        = team =

    @on *
        | amount of visible &boxes should be 9
        | amount of visible &columns should be 3
        @for [1 - 3] as index
                team.box-${index}:
                    inside team.column-1
        @for [4 - 6] as index
                team.box-${index}:
                    inside team.column-2
        @for [7 - 9] as index
                team.box-${index}:
                    inside team.column-3

    @on desktop
        | &columns are placed next to each other with ${no_margin}

    @on tablet, mobile
        | &columns are placed above each other with ~ 1px margin

