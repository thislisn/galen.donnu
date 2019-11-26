package com.galenframework.java.sample.stepDefinitions;

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

import static java.lang.String.format;

public class GAFLayoutStepDefinitions extends GalenTestBase {

    @Then("^layout suite rules is satisfied:$")
    public void layoutSuiteRulesFromGspecFile(DataTable dataTable) throws IOException {
        Map<String, String> deviceMap = dataTable.asMap(String.class, String.class);
        TestDevice device = GalenTestBase.getDevice(deviceMap.get("device"));
//        LayoutReport layoutReport = Galen.checkLayout(getWebDriver(), "com/galenframework/java/sample/specs/" + galenSpecFile,
//                Arrays.asList("mobile"));

//        checkLayout(format(SPEC_PATH_MASK, deviceMap.get("spec")), device.getTags());
//        buildReport(layoutReport, galenSpecFile);

        String galenSpecFile = "studRada_main";
        LayoutReport layoutReport = Galen.checkLayout(getDriver(), format(SPEC_PATH_MASK, galenSpecFile),
                new SectionFilter(device.getTags(), Collections.emptyList()), new Properties(), null, null);
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
