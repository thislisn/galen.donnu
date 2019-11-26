package com.galenframework.java.sample.config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GafBrowserManager {

    static final String CHROME = "chrome";
    static final String FIREFOX = "firefox";
    static final String EDGE = "edge";

    public static void setup() {
        switch (GafConfiguration.browser) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                break;
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                break;
            }
            default: {
                throw new RuntimeException("Browser " + GafConfiguration.browser + " is not supported");
            }
        }
        Configuration.browser = GafConfiguration.browser;
    }
}
