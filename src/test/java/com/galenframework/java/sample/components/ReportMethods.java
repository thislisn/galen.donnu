package com.galenframework.java.sample.components;

import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;

@Slf4j
public class ReportMethods extends GalenTestBase {
    protected GalenScenario galenScenario = GalenScenario.getInstance();
    protected static final String IMG_DIFF_PATH = loadSystemPropertyOrDefault("imgDiff",
            System.getProperty("user.dir") + "/target/results-img/");

    @SneakyThrows
    public void checkLayoutAccordingToSpec(WebDriver driver, String specPath, List<String> tags) {
        LayoutReport report = Galen.checkLayout(driver, specPath, tags);
        report.getFileStorage().copyAllFilesTo(new File(IMG_DIFF_PATH));
        String title = "Check layout " + specPath;
        getReport().layout(report, title).getLayoutReport();
        if (report.errors() > 0) {
            embedScreenshotAndFail(report);
        }
    }

    public static String loadSystemPropertyOrDefault(String propertyName, String defaultValue) {
        String propValue = System.getProperty(propertyName);
        return propValue != null ? propValue : defaultValue;
    }

    private void embedScreenshotAndFail(LayoutReport report) {
        Map<String, File> screenshots = report.getFileStorage().getFiles();
        screenshots.forEach((key, value) -> {
            if (key.contains("map") || key.contains("expected") || key.contains("actual")) {
                galenScenario.write(key);
                embedFileToReport(value, "image/png");
            }
        });
        fail(report.getValidationErrorResults().toString());
    }

    @SneakyThrows
    public static void embedFileToReport(File fileName, String mimeType) {
        GalenScenario.getInstance().getScenario()
                .embed(FileUtils.readFileToByteArray(fileName), mimeType);
    }
}
