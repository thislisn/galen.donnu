package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.page.GafBasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class GAFParameters {

//    @When("^user add '(.*)' to url$")
//    public void userAddCbviewerNoneToUrl(String url_suffix) {
//        Selenide.open(url() + url_suffix);
//    }
//
//    @Then("^all links on the page has '(.*)'$")
//    public void allLinksOnThePageHasUrlParameter(String url_suffix) {
//        // get all links from the page
//        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);
//        final List<String> listOfLinks = gafBasePage.getListOfUniqueLinks();
//
//        // verify that each link contain url_suffix
//        assertThat(listOfLinks)
//                .allMatch(eachURL -> eachURL.contains(url_suffix));
//    }
}
