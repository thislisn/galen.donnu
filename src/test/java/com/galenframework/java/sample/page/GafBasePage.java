package com.galenframework.java.sample.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.galenframework.java.sample.page.footer.Footer;
import com.galenframework.java.sample.page.header.TopMenu;
import com.galenframework.java.sample.utils.LinkUtils;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GafBasePage {

//    public TopMenu getTopMenu() {
//        return Selenide.page( TopMenu.class );
//    }
//
//    public Footer getFooter() {
//        return Selenide.page( Footer.class );
//    }
//
//    public List<String> getListOfUniqueLinks() {
//        final ElementsCollection allLinksA = $$( "a" );
//
//        LinkUtils linkUtils = new LinkUtils();
//        return linkUtils.from( allLinksA ).getUnique().getLinks();
//    }
//
//    public String getAllVisibleText() {
//        return $( By.tagName( "body" ) ).getText();
//    }

}
