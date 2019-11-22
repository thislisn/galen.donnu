package com.galenframework.java.sample.page.searchComponents;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductResult {
    @FindBy(xpath = ".//span[@class='product-name']")
    private SelenideElement productTitle;

    @FindBy(xpath = ".//div[@class='content']/span")
    private SelenideElement productDescription;


    public String getTitleAndDescription() {
        return productTitle.getText() + productDescription.getText();
    }
}
