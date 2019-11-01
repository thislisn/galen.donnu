package com.galenframework.java.sample.components;

import com.galenframework.testng.GalenTestNgTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;

import static java.lang.String.format;
import static java.lang.System.*;
import static java.util.Collections.singletonList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    private static final String LOCAL_PATH_MASK = "\\app\\%s\\%s\\%s\\index.html";
    public static final String SPEC_PATH_MASK = "/specs/%s.spec";
    private static final String URL_MASK = "https://%s/%s/%s";

    @BeforeSuite
    public void deleteReport() {
        File file = new File("target/galen-html-reports/report.html");
        file.delete();
    }

    @Override
    public WebDriver createDriver(Object[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice) args[0];
                if (device.getScreenSize() != null) {
                    driver.manage().window().setSize(device.getScreenSize());
                }
            }
        }
        return driver;
    }

    protected String getLocalUrl(LOCAL local, String uri, Domain domain) {
        return getProperty("user.dir").concat(format(LOCAL_PATH_MASK, domain.name, local.name, uri));
    }

    protected String getProductionUrl(LOCAL local, String uri, Domain domain){
        return format(URL_MASK, domain.name, local.name, uri);
    }

    @DataProvider(name = "devices")
    public Object[][] devices() {
        return new Object[][]{
                {new TestDevice("mobile", new Dimension(450, 800), singletonList("mobile"))},
                {new TestDevice("tablet", new Dimension(750, 800), singletonList("tablet"))},
                {new TestDevice("desktop", new Dimension(1280, 800), singletonList("desktop"))}
        };
    }

    @AllArgsConstructor
    public enum Domain {
        MAIN("www.donnu.edu.ua"),
        SCIENCE("science.donnu.edu.ua");

        private final String name;

        @Override
        public String toString() {
            return name;
        }
    }

    @AllArgsConstructor
    public enum LOCAL {
        EN("en"),
        UA("uk");

        private final String name;

        @Override
        public String toString() {
            return name;
        }
    }
}
