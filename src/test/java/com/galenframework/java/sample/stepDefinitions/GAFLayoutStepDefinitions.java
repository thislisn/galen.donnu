package com.galenframework.java.sample.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.api.Galen;
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
import org.junit.Assert;

import java.io.IOException;
import java.util.*;

import static com.galenframework.api.Galen.checkLayout;
import static com.galenframework.java.sample.components.GalenTestBase.SPEC_PATH_MASK;
import static java.lang.String.format;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GAFLayoutStepDefinitions {

    @Then("^layout suite rules is satisfied:$")
    public void layoutSuiteRulesFromGspecFile(DataTable dataTable) throws IOException {

        Map<String, String> deviceMap = dataTable.asMap(String.class, String.class);
        TestDevice device = GalenTestBase.getDevice(deviceMap.get("device"));
        String galenSpecFile = deviceMap.get("spec");
//        LayoutReport layoutReport = Galen.checkLayout(getWebDriver(), format(SPEC_PATH_MASK, galenSpecFile),
//                Arrays.asList("mobile"));

        LayoutReport layoutReport = checkLayout(getWebDriver(), format(SPEC_PATH_MASK, galenSpecFile),
                new SectionFilter(device.getTags(), Collections.emptyList()), new Properties(), null, null);

        // import GalenJavaTestBase
//        checkLayout(format(SPEC_PATH_MASK, deviceMap.get("spec")), device.getTags());

//
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

//    private void buildReport(LayoutReport layoutReport, String galenSpecFile) throws IOException {
//        GalenTestInfo test = GalenTestInfo.fromString(galenSpecFile);
//        test.getReport().layout(layoutReport, "check layout according to rules inside " + galenSpecFile);
//
//        List<GalenTestInfo> tests = new LinkedList<>();
//        tests.add(test);
//
//        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
//        htmlReportBuilder.build(tests, "target/GalenReports");
//
//        new ReportWriter().writeLinkToGalenReport(galenSpecFile);
//
//        if (layoutReport.errors() > 0) {
//            Assert.fail("Website page layout tests failed");
//        }
//    }
}
