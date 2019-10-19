package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import org.testng.annotations.Test;

import java.io.IOException;


public class DesignTestProductions extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void checkLayoutProduction(TestDevice device) throws IOException {
        load(getProductionURL("uk", "studentska-rada"));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void checkLayoutProductionEn(TestDevice device) throws IOException {
        load(getProductionURL("en", "student-council"));
        checkLayout("/specs/studRada.spec", device.getTags());
    }

}
