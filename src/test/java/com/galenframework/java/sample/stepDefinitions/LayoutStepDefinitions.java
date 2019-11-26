package com.galenframework.java.sample.stepDefinitions;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import com.galenframework.java.sample.page.context.ScenarioContext;
import com.galenframework.java.sample.utils.ReportWriter;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.speclang2.pagespec.SectionFilter;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import lombok.SneakyThrows;
import org.junit.Assert;

import java.io.IOException;
import java.util.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.galenframework.api.Galen.checkLayout;
import static com.galenframework.java.sample.components.GalenTestBase.SPEC_PATH_MASK;
import static java.lang.String.format;

public class LayoutStepDefinitions {

    @SneakyThrows
    @Then("^layout suite rules is satisfied:$")
    public void layoutSuiteRulesFromGspecFile(DataTable dataTable) {
        Map<String, String> deviceMap = dataTable.asMap(String.class, String.class);
        TestDevice device = GalenTestBase.getDevice(deviceMap.get("device"));
        String galenSpecFile = deviceMap.get("spec");

        LayoutReport layoutReport = checkLayout(getWebDriver(), format(SPEC_PATH_MASK, galenSpecFile),
                new SectionFilter(device.getTags(), Collections.emptyList()), new Properties(), null, null);

        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString(galenSpecFile);
        test.getReport().layout(layoutReport, "check layout on mobile device");
        tests.add(test);
        new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        Scenario scenario = ScenarioContext.get("scenario");
        new ReportWriter().writeLinkToGalenReport(galenSpecFile);
        if (layoutReport.errors() > 0) {
            Assert.fail("Website page layout tests failed");
        }
    }
}
