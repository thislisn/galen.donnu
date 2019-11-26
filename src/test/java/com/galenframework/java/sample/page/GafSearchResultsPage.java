package com.galenframework.java.sample.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.galenframework.java.sample.page.searchComponents.ContentTypeFilter;
import com.galenframework.java.sample.page.searchComponents.PageResult;
import com.galenframework.java.sample.page.searchComponents.ProductResult;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GafSearchResultsPage {

//    @FindBy( id = "header-search-input" )
//    private SelenideElement searchInput;
//
//    @FindBy( xpath = "//div[@class='filter-option-inner-inner']" )
//    private SelenideElement searchFilterOption;
//
//    @FindBy( xpath = "(//form[@name='search']//button[@type='submit' and not (@disabled='disabled')])[1]" )
//    private SelenideElement searchButton;
//
//    @FindBy( xpath = "//form[@name='search']//button[@type='submit' and @disabled='disabled']" )
//    private List<ProductResult> searchButtonDisabled;
//
//    @FindBy( xpath = "//div[contains(@class, 'search-body')]//div[@class='no-results']" )
//    private SelenideElement noResults;
//
//    @FindBy( xpath = "//nav[contains(@class, 'search-open')]" )
//    private SelenideElement isPanelOpened;
//
//    @FindBy( xpath = "//div[@class='search-container']//a[@title='Search']" )
//    private SelenideElement closeSearchIcon;
//
//    @FindBy( xpath = "//div[contains(@class, 'loading') and contains(@class, 'search-results-wrapper')]" )
//    private SelenideElement searchSpinner;
//
//    @FindBy( xpath = ".//div[@class='search-result-item']/div[@class='search-article']" )
//    private List<PageResult> pageResultList;
//
//    @FindBy( xpath = ".//div[@class='search-product']" )
//    private List<ProductResult> productResultsList;
//
//    @FindBy( xpath = "//ul[@role='tablist']//h4/a" )
//    private List<ContentTypeFilter> contentTypeFilter;
//
//    public List<ContentTypeFilter> getContentTypeFilter() {
//        return contentTypeFilter;
//    }
//
//    public ContentTypeFilter getContentTypeFilterByTitle( String filterTitle ) {
//        ContentTypeFilter contentTypeFilterResult = getContentTypeFilter()
//                .stream()
//                .filter( contentTypeFilterItem -> contentTypeFilterItem.getCategoryTitle().toLowerCase().contains( filterTitle ) )
//                .findFirst().orElse( null );
//
//        return contentTypeFilterResult;
//    }
//
//    public List<PageResult> getPagesList() {
//        return pageResultList;
//    }
//
//    public List<ProductResult> getProductsList() {
//        return productResultsList;
//    }
//
//    public boolean isSearchButtonActive() {
//        return searchButtonDisabled.isEmpty();
//    }
//
//    public GafSearchResultsPage search( String keyword ) {
//        searchInput.setValue( keyword );
//        searchButton.click();
//        waitForSpinner();
//
//        return Selenide.page( GafSearchResultsPage.class );
//    }
//
//    public String getNoResultsMessageText() {
//        String result = "";
//
//        if ( noResults.isDisplayed() ) {
//            result = noResults.getText();
//        }
//
//        return result;
//    }
//
//    public void closeSearchPanelByXButton() {
//        closeSearchIcon.click();
//    }
//
//    public boolean isSearchPanelDisplayed() {
//        return isPanelOpened.exists();
//    }
//
//    private void waitForSpinner() {
//        searchSpinner.waitUntil( Condition.exist, 1000 );
//        searchSpinner.waitUntil( Condition.disappear, 15000 );
//    }
//
//    public String getActiveSearchType() {
//        return searchFilterOption.getText();
//    }
}
