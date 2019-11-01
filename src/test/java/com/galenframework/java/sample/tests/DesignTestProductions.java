package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.String.format;


public class DesignTestProductions extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void checkLayoutProduction(TestDevice device) throws IOException {
        load(getProductionUrl(LOCAL.UA, "studentska-rada", Domain.MAIN));
        checkLayout(format(SPEC_PATH_MASK, "studRada"), device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutProductionEn(TestDevice device) throws IOException {
        load(getProductionUrl(LOCAL.EN, "student-council", Domain.MAIN));
        checkLayout(format(SPEC_PATH_MASK, "studRada"), device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutProductionUkScience(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.UA, "pro-donnu", Domain.SCIENCE));
        checkLayout(format(SPEC_PATH_MASK, "header_science"), device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutProductionEnScience(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.EN, "about-donnu", Domain.SCIENCE));
        checkLayout(format(SPEC_PATH_MASK, "header_science"), device.getTags());
    }

}
