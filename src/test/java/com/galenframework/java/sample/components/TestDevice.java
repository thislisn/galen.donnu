package com.galenframework.java.sample.components;

import lombok.Data;
import org.openqa.selenium.Dimension;

import java.util.List;

@Data
public class TestDevice {
    private final String name;
    private final Dimension screenSize;
    private final List<String> tags;

    @Override
    public String toString() {
        return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
    }
}
