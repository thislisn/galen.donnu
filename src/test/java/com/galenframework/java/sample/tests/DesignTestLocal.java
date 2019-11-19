package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import static java.lang.String.format;


public class DesignTestLocal extends GalenTestBase {

    @SneakyThrows
    @Test(dataProvider = "devices")
    public void checkLayoutLocalUkMain(TestDevice device) {
        load(getLocalUrl(LOCAL.UA, "studentska-rada", Domain.MAIN));
        checkLayout(format(SPEC_PATH_MASK, "studRada_main"), device.getTags());
    }

    @SneakyThrows
    @Test(dataProvider = "devices")
    public void checkLayoutLocalEnMain(TestDevice device) {
        load(getLocalUrl(LOCAL.EN, "student-council", Domain.MAIN));
        checkLayout(format(SPEC_PATH_MASK, "studRada_main"), device.getTags());
    }

    @SneakyThrows
    @Test(dataProvider = "devices")
    public void checkLayoutLocalUkScience(TestDevice device) {
        load(getLocalUrl(LOCAL.UA, "pro-donnu", Domain.SCIENCE));
        checkLayout(format(SPEC_PATH_MASK, "about_science"), device.getTags());
    }

    @SneakyThrows
    @Test(dataProvider = "devices")
    public void checkLayoutLocalEnScience(TestDevice device) {
        load(getLocalUrl(LOCAL.EN, "about-donnu", Domain.SCIENCE));
        checkLayout(format(SPEC_PATH_MASK, "about_science"), device.getTags());
    }

}
