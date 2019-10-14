package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.TestDevice;
import org.testng.annotations.Test;

import java.io.IOException;


public class DesignTest extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void checkLayout(TestDevice device) throws IOException {
        load("/studentska-rada/");
        checkLayout("/specs/studRada.spec", device.getTags());
    }

}
