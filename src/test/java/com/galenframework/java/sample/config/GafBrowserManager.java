package com.galenframework.java.sample.config;

import com.codeborne.selenide.Configuration;
import com.galenframework.java.sample.components.TestDevice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.Collections.singletonList;

public class GafBrowserManager {

    static final String CHROME = "chrome";
    static final String FIREFOX = "firefox";
    static final String IE = "ie";


    public static void setup() {
        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        TestDevice device = new TestDevice("mobile", new Dimension(450, 800), singletonList("mobile"));
//        driver.manage().window().setSize(device.getScreenSize());
        Configuration.browser = GafConfiguration.browser;
    }
}
