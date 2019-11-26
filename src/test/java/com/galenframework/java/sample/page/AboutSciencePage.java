package com.galenframework.java.sample.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AboutSciencePage {
    @FindBy(css = "footer#main-footer")
    private SelenideElement footer;

    @FindBy(css = "#page-container #main-header")
    private SelenideElement header;

    public boolean isFooterDisplayed(){
        return footer.isDisplayed();
    }

    public boolean isHeaderDisplayed(){
        return header.isDisplayed();
    }
}
