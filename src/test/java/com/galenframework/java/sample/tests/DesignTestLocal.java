package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import org.testng.annotations.Test;

import java.io.IOException;


public class DesignTestLocal extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void checkLayoutLocalUkMain(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.UA, "studentska-rada", Domain.MAIN));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutLocalEnMain(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.EN, "student-council", Domain.MAIN));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutLocalUkScience(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.UA, "pro-donnu", Domain.SCIENCE));
        checkLayout("/specs/footer_science.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutLocalEnScience(TestDevice device) throws IOException {
        load(getLocalUrl(LOCAL.EN, "about-donnu", Domain.SCIENCE));
        checkLayout("/specs/footer_science.spec", device.getTags());
    }

}
