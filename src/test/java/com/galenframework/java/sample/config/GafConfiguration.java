package com.galenframework.java.sample.config;

import static com.galenframework.java.sample.config.GafBrowserManager.CHROME;

public class GafConfiguration {
//    public static final String HOME_UA_PROD = System.getProperty("home.ua.prod", "https://www.donnu.edu.ua/uk/");
//    public static final String HOME_EN_PROD = System.getProperty("home.en.prod", "https://www.donnu.edu.ua/en/");
//    public static final String STUD_EN_PROD = System.getProperty("stud.en.prod",  "https://www.donnu.edu.ua/en/student-council/");
//    public static final String STUD_UA_PROD = System.getProperty("stud.ua.prod",  "https://www.donnu.edu.ua/studentska-rada/");
//    public static final String SCIENCE_UA_PROD = System.getProperty("science.ua.prod",  "https://science.donnu.edu.ua/uk/pro-donnu/");
//    public static final String SCIENCE_EN_PROD = System.getProperty("science.en.prod",  "https://science.donnu.edu.ua/en/about-donnu/");

        public static final String HOME_UA_PROD = System.getProperty("home.ua.prod", "");
    public static final String HOME_EN_PROD = System.getProperty("home.en.prod", "");
    public static final String STUD_EN_PROD = System.getProperty("stud.en.prod",  "");
    public static final String STUD_UA_PROD = System.getProperty("stud.ua.prod",  "");
    public static final String SCIENCE_UA_PROD = System.getProperty("science.ua.prod",  "");
    public static final String SCIENCE_EN_PROD = System.getProperty("science.en.prod",  "");

    public static String browser = System.getProperty("browser", CHROME).toLowerCase();
}
