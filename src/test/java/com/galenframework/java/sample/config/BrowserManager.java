package com.galenframework.java.sample.config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

    static final String CHROME = "chrome";
    static final String FIREFOX = "firefox";
    static final String EDGE = "edge";

    public static void setup() {
        switch (Configuration.browser) {
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
                throw new RuntimeException("Browser " + Configuration.browser + " is not supported");
            }
        }
        com.codeborne.selenide.Configuration.browser = Configuration.browser;
    }
}
