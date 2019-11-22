package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.galenframework.java.sample.config.GafBrowserManager;
import com.galenframework.java.sample.config.GafConfiguration;
import com.galenframework.java.sample.page.context.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    @Before
    public void before(Scenario scenario) {
        // Configuration.baseUrl = "https://webuat.gaf.com/en-us/"
        // set default browser website to open
        Configuration.baseUrl = GafConfiguration.HOME_UA_PROD;
        Configuration.startMaximized=false;
//        Configuration.browserSize = "1280x800";

        // Configure browser to use using bonigarcia, that download chromeDriver.exe or some other depending on parameters
        // default browser = Chrome
        GafBrowserManager.setup();

        // initialize context to pass variables between scenario steps
        new ScenarioContext().init();
        ScenarioContext.put("scenario", scenario);

        // folder for temporary screenshots and logs during tests run
        Configuration.reportsFolder = "target/build/reports/tests";

        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");

        // Galen Framework configuration
        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE_SCROLLWAIT, "100");
    }

    @After
    public void after(Scenario scenario) {
        // attach screenshot for functional UI tests Selenide (WebDriver Selenium tests)
        if (scenario.isFailed() && WebDriverRunner.hasWebDriverStarted()) {
            scenario.write("Scenario '" + scenario.getName() + "' failed. Making screenshot");

            byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("------------------------------");
        System.out.println("Finishing - " + scenario.getName() + " .Status - " + scenario.getStatus());
        System.out.println("------------------------------");
        getWebDriver().close();
    }
}
