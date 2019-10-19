package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import org.testng.annotations.Test;

import java.io.IOException;


public class DesignTestLocal extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void checkLayoutLocal(TestDevice device) throws IOException {
        load(getLocalURL("uk", "studentska-rada"));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutLocalEn(TestDevice device) throws IOException {
        load(getLocalURL("en", "student-council"));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

}
