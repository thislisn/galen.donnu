package com.galenframework.java.sample.page.searchComponents;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ContentTypeFilter {

    @FindBy(xpath = ".//span[@class='category-title']")
    private SelenideElement categoryTitle;

    @FindBy(xpath = ".//span[@class='result-count']")
    private SelenideElement resultCount;


    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public long getResultCount() {
        return Long.parseLong(resultCount.getText().replaceAll("\\D", ""));
    }
}
