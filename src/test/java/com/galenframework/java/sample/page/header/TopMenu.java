package com.galenframework.java.sample.page.header;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.galenframework.java.sample.page.GafSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class TopMenu {

//    @FindBy( xpath = "//div[@class='mp-menu']/div[contains(@class, 'top-level')]" )
//    private SelenideElement topMenu;
//
//    @FindBy( xpath = "//div[@class='search-container']//a[@title='Search']" )
//    private SelenideElement searchIcon;
//
//    public Logo getLogo() {
//        return Selenide.page( Logo.class );
//    }
//
//    public SelenideElement getLinkByName( String menuTitle ) {
//        return topMenu.$( By.xpath( "//li/a[@title='" + menuTitle + "']" ) );
//    }
//
//    public GafSearchResultsPage openSearchPanel() {
//        searchIcon.click();
//        return Selenide.page( GafSearchResultsPage.class );
//    }
//
//    public boolean isShown() {
//        return topMenu.isDisplayed();
//    }
//
//    public boolean isSearchIconShown() {
//        return searchIcon.isDisplayed();
//    }
}
