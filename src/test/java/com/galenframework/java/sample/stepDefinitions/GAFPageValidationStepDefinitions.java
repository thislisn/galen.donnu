package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.config.GafConfiguration;
import com.galenframework.java.sample.page.GafBasePage;
import com.galenframework.java.sample.utils.ReportWriter;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GAFPageValidationStepDefinitions {

    @Then("^all text on the '(.*)' page is the same as on page on Production$")
    public void allTextOnTheTestEnvironmentURLPageIsTheSameAsOnTheSamePageOnProduction(String pageLink) throws Throwable {
        GafBasePage gafBasePage = Selenide.open(Configuration.baseUrl + pageLink, GafBasePage.class);
        String allVisibleText = gafBasePage.getAllVisibleText();

        GafBasePage gafBasePageProduction = Selenide.open(GafConfiguration.HOME_UA_PROD + pageLink, GafBasePage.class);
        String allVisibleTextOfProduction = gafBasePageProduction.getAllVisibleText();

        assertThat(allVisibleText).
                as("Check if text on the page: " + Configuration.baseUrl + pageLink +
                        " is the same as text on the page: " + GafConfiguration.HOME_UA_PROD + pageLink).
                isEqualTo(allVisibleTextOfProduction);
    }

    @Then("^all links on the '(.*)' page is the same as on page on Production$")
    public void allLinksOnTheTestEnvironmentURLPageIsTheSameAsOnTheSamePageOnProduction(String pageLink) throws Throwable {
        GafBasePage gafBasePage = Selenide.open(Configuration.baseUrl + pageLink, GafBasePage.class);
        List<String> allLinks = gafBasePage.getListOfUniqueLinks();

        // replace domain from webuat.gaf.com -> www.gaf.com
        List<String> allLinksReplacedDomain = allLinks.
                stream().
                map(url -> url.replace(Configuration.baseUrl.replace("/en-us", ""),
                        GafConfiguration.HOME_UA_PROD.replace("/en-us", ""))).
                collect(Collectors.toList());

        GafBasePage gafBasePageProduction = Selenide.open(GafConfiguration.HOME_UA_PROD + pageLink, GafBasePage.class);
        List<String> allLinksProduction = gafBasePageProduction.getListOfUniqueLinks();

        new ReportWriter().writeCollectionComparisonReport(allLinksReplacedDomain, allLinksProduction);

        assertThat(allLinksReplacedDomain).
                as("Check if links on " + Configuration.baseUrl + pageLink +
                        " has the same amount as links on the page as " + GafConfiguration.HOME_UA_PROD + pageLink).
                hasSameSizeAs(allLinksProduction);

        assertThat(allLinksReplacedDomain.equals(allLinksProduction)).
                as("Check if links on " + Configuration.baseUrl + pageLink +
                        " has the same links on the page as " + GafConfiguration.HOME_UA_PROD + pageLink).
                isTrue();
    }
}
