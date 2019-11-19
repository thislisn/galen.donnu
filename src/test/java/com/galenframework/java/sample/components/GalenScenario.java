package com.galenframework.java.sample.components;

import io.cucumber.core.api.Scenario;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class GalenScenario {

    private static GalenScenario instance = new GalenScenario();
    private static GalenEnvironment environment;

    public static GalenScenario getInstance() {
        return instance;
    }

    public GalenEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(GalenEnvironment galenEnvironment) {
        environment = galenEnvironment;
    }

    public Scenario getScenario() {
        return this.getEnvironment().getScenario();
    }

    public void write(Object object) {
        this.getEnvironment().write(object);
    }

    public <T extends GalenPage> T getPage(Class<T> clazz) {
        return Pages.getPage(clazz, true);
    }

}
