package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.page.GafBasePage;
import com.galenframework.java.sample.utils.LinkUtils;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class GAFNavigationStepDefinitions {

    @Then("^header has logo shown$")
    public void headerHasLogoShown() throws Throwable {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);

        assertThat(gafBasePage.getTopMenu().getLogo().getImage().isImage()).
                as("Check if Logo image is displayed").
                isTrue();
    }

    @Then("^header has search button shown$")
    public void headerHasSearchButtonShown() throws Throwable {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);

        assertThat(gafBasePage.getTopMenu().isSearchIconShown()).
                as("Check if Search icon is displayed").
                isTrue();
    }

    @Then("^header has '(.*)' that link to '(.*)'$")
    public void headerHaveMenuItemThatLinkToURL(String menuTitle, String urlPart) {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);

        assertThat(new LinkUtils().getURL(gafBasePage.getTopMenu().getLinkByName(menuTitle))).
                as("Check if link " + menuTitle + " contains part of URL " + urlPart).
                containsIgnoringCase(urlPart);
    }

    @Then("^footer has '(.*)' that link to '(.*)'$")
    public void footerHaveMenuItemThatLinkToURL(String footerLinkTitle, String urlPart) {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);

        assertThat(new LinkUtils().getURL(gafBasePage.getFooter().getFooterLinkByName(footerLinkTitle))).
                as("Check if link " + footerLinkTitle + " contains part of URL " + urlPart).
                containsIgnoringCase(urlPart);
    }
}
