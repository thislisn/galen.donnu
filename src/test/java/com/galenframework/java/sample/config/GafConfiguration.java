package com.galenframework.java.sample.config;

import static com.galenframework.java.sample.config.GafBrowserManager.CHROME;

public class GafConfiguration {
    public static final String HOME_UA_PROD = System.getProperty("home.ua.prod", "");
    public static final String HOME_EN_PROD = System.getProperty("home.en.prod", "");

    public static String browser = System.getProperty("browser", CHROME).toLowerCase();
    public static String browserSize = System.getProperty("browserSize", "1280x800").toLowerCase();
    public static String url = System.getProperty("url", HOME_UA_PROD).toLowerCase();
}
