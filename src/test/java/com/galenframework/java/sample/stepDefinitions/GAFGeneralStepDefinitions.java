package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import com.galenframework.java.sample.config.GafConfiguration;
import com.galenframework.java.sample.page.GafBasePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Map;

import static com.galenframework.suite.GalenPageActions.open;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class GAFGeneralStepDefinitions extends GalenTestBase {

    @Given("^an open browser with GAF base url$")
    public void anOpenBrowserWithGAFBaseUrl() {
        Selenide.open(Configuration.baseUrl, GafBasePage.class);
    }

    @Given("^an open browser with GAF url$")
    public void anOpenBrowserWithGAFUrl() {
        Configuration.baseUrl = GafConfiguration.HOME_UA_PROD;
        Selenide.open(Configuration.baseUrl, GafBasePage.class);
    }

    @Given("^open local browser with url:$")
    public void openBrowserWithUrl(DataTable dataTable) {
        Map<String, String> urlMap = dataTable.asMap(String.class, String.class);
        Configuration.browserSize = urlMap.get("resolution");
        Selenide.open(getLocalUrl(dataTable));

    }

    @Then("^top navigation (is|is not) shown$")
    public void topNavigationIsNotShown(String expectation) {
        if (expectation.equals("is not")) {
            // expect to have navigation not shown
            GafBasePage gafBasePage = Selenide.page(GafBasePage.class);
            assertThat(gafBasePage.getTopMenu().isShown()).
                    as("Check if Top navigation menu is shown. Expecting to be not shown").
                    isFalse();
        } else {
            // expect to have navigation shown
            GafBasePage gafBasePage = Selenide.page(GafBasePage.class);
            assertThat(gafBasePage.getTopMenu().isShown()).
                    as("Check if Top navigation menu is shown. Expecting to be shown").
                    isTrue();
        }
    }
}
