package com.galenframework.java.sample.page.searchComponents;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PageResult {

    @FindBy(xpath = ".//a/h3")
    private SelenideElement pageTitle;

    @FindBy(xpath = ".//span[contains(@class,'search-product-card-description')]")
    private SelenideElement pageDescription;


    public String getTitleAndDescription() {
        return pageTitle.getText() + pageDescription.getText();
    }
}
