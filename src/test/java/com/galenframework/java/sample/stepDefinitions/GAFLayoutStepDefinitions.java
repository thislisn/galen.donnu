package com.galenframework.java.sample.stepDefinitions;

import com.galenframework.api.Galen;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import com.galenframework.java.sample.utils.ReportWriter;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.support.GalenJavaTestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.galenframework.java.sample.components.GalenTestBase.SPEC_PATH_MASK;
import static java.lang.String.format;

public class GAFLayoutStepDefinitions extends GalenTestBase {

    @Then("^layout suite rules is satisfied:$")
    public void layoutSuiteRulesFromGspecFile(DataTable dataTable) {
        Map<String, String> deviceMap = dataTable.asMap(String.class, String.class);
        TestDevice device = GalenTestBase.getDevice(deviceMap.get("device"));
//        LayoutReport layoutReport = Galen.checkLayout(getWebDriver(), "com/galenframework/java/sample/specs/" + galenSpecFile,
//                Arrays.asList("mobile"));

//        checkLayout(format(SPEC_PATH_MASK, deviceMap.get("spec")), device.getTags());
//        buildReport(layoutReport, galenSpecFile);
    }

    private void buildReport(LayoutReport layoutReport, String galenSpecFile) throws IOException {
        GalenTestInfo test = GalenTestInfo.fromString(galenSpecFile);
        test.getReport().layout(layoutReport, "check layout according to rules inside " + galenSpecFile);

        List<GalenTestInfo> tests = new LinkedList<>();
        tests.add(test);

        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(tests, "target/GalenReports");

        new ReportWriter().writeLinkToGalenReport(galenSpecFile);

        if (layoutReport.errors() > 0) {
            Assert.fail("Website page layout tests failed");
        }
    }
}
