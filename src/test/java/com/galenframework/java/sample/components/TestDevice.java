package com.galenframework.java.sample.components;

import org.openqa.selenium.Dimension;

import java.util.List;

public class TestDevice {
    private final String name;
    private final Dimension screenSize;
    private final List<String> tags;

    public TestDevice(String name, Dimension screenSize, List<String> tags) {
        this.name = name;
        this.screenSize = screenSize;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
    }
}
