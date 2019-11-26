package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.galenframework.java.sample.config.BrowserManager;
import com.galenframework.java.sample.config.Configuration;
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
        com.codeborne.selenide.Configuration.baseUrl = Configuration.url;
        com.codeborne.selenide.Configuration.startMaximized = false;
        BrowserManager.setup();
        new ScenarioContext().init();
        ScenarioContext.put("scenario", scenario);
        com.codeborne.selenide.Configuration.reportsFolder = "target/build/reports/tests";

        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");

        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE_SCROLLWAIT, "100");
    }

    @After
    public void after(Scenario scenario) {
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
