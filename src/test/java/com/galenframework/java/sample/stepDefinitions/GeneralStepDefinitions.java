package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.page.AboutSciencePage;
import com.galenframework.java.sample.page.StudRadaPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralStepDefinitions extends GalenTestBase {

    @Given("^open local browser with url:$")
    public void openBrowserWithUrl(DataTable dataTable) {
        Map<String, String> urlMap = dataTable.asMap(String.class, String.class);
        Configuration.browserSize = urlMap.get("resolution");
        Selenide.open(getLocalUrl(dataTable));
    }

    @Then("^stud rada header is visible$")
    public void studRadaHeaderIsVisible() {
        StudRadaPage studRadaPage = Selenide.page(StudRadaPage.class);
        assertThat(studRadaPage.isHeaderDisplayed()).
                as("header is visible on stud rada page").
                isTrue();
    }

    @Then("^about science header is visible$")
    public void aboutScienceHeaderIsVisible() {
        AboutSciencePage aboutSciencePage = Selenide.page(AboutSciencePage.class);
        assertThat(aboutSciencePage.isHeaderDisplayed()).
                as("header is visible on about science page").
                isTrue();
    }
}
