package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.page.GafBasePage;
import com.galenframework.java.sample.page.GafSearchResultsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GAFSearchStepDefinitions {

    @When("^user searched for (.*) in search panel$")
    public void userSearchedForInSearchPanel(String query) {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);
        gafBasePage.getTopMenu().openSearchPanel().search(query);
    }

    @Then("^all results products title and description should contain (.*)$")
    public void allResultsProductsTitleAndDescriptionShouldContainRoof(String keyword) {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        assertThat(gafSearchResultsPage.getProductsList())
                .allMatch(productResult -> productResult.getTitleAndDescription().toLowerCase().contains(keyword));
    }

    @Then("^all results pages title and description should contain (.*)")
    public void allResultsPagesTitleAndDescriptionShouldContainRoof(String keyword) {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        assertThat(gafSearchResultsPage.getPagesList())
                .allMatch(pageResult -> pageResult.getTitleAndDescription().toLowerCase().contains(keyword));
    }

    @When("^search panel is opened$")
    public void searchPanelIsOpened() {
        GafBasePage gafBasePage = Selenide.page(GafBasePage.class);
        gafBasePage.getTopMenu().openSearchPanel();
    }

    @Then("^the Search button is not active$")
    public void theSearchButtonIsNotActive() {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        assertThat(gafSearchResultsPage.isSearchButtonActive()).
                as("Check if Search button is not active").
                isFalse();
    }

    @Then("^message that there are no results should be shown$")
    public void messageThatThereAreNoResultsShouldBeShown() {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        assertThat(gafSearchResultsPage.getNoResultsMessageText()).
                as("Check if result message").
                contains("Sorry, we couldn't find any results matching ");
    }

    @Then("^amount of results in each filter is > (\\d+)$")
    public void amountOfResultsInEachFilterProductsIs(int expectedMinimumAmount, DataTable filterCategories) {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        List<String> filterCategoriesList = new ArrayList<>();
        for (List<String> internalList : filterCategories.raw()) {
            filterCategoriesList.add(internalList.get(0));
        }

        for (String filterCategory : filterCategoriesList) {
            assertThat(gafSearchResultsPage.getContentTypeFilterByTitle(filterCategory).getResultCount()).isGreaterThan(expectedMinimumAmount);
        }
    }

    @Then("^amount of results in filter (.*) is > (\\d+)$")
    public void amountOfResultsInFilterProductsIs(String filterCategory, int expectedMinimumAmount) {
        GafSearchResultsPage gafSearchResultsPage = Selenide.page(GafSearchResultsPage.class);

        assertThat(gafSearchResultsPage.getContentTypeFilterByTitle(filterCategory).getResultCount()).isGreaterThan(expectedMinimumAmount);
    }
}
