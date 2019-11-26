package com.galenframework.java.sample.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class  StudRadaPage {

    @FindBy(css = "header.site-header.main-header")
    private SelenideElement header;

    @FindBy(css = "footer#footer")
    private SelenideElement footer;

    public boolean isFooterDisplayed(){
        return footer.isDisplayed();
    }

    public boolean isHeaderDisplayed(){
        return header.isDisplayed();
    }
}
