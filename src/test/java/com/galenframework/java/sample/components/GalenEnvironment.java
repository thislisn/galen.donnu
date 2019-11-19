package com.galenframework.java.sample.components;

import io.cucumber.core.api.Scenario;
import lombok.SneakyThrows;

import java.util.Arrays;

public class GalenEnvironment {
    private Scenario scenario;
    private Pages pages = new Pages();

    public GalenEnvironment(Scenario scenario) {
        this.scenario = scenario;
        initPages();
    }

    public GalenEnvironment() {
        initPages();
    }

    @SneakyThrows
    private void initPages() {
        new AnnotationScanner().getClassesAnnotatedWith(Name.class)
                .stream()
                .map(it -> {
                    if (GalenPage.class.isAssignableFrom(it)) {
                        return (Class<? extends GalenPage>) it;
                    } else {
                        throw new IllegalStateException("Класс " + it.getName() + " должен наследоваться от GalenPage");
                    }
                })
                .forEach(clazz -> pages.put(getClassAnnotationValue(clazz), clazz));
    }

    private String getClassAnnotationValue(Class<?> c) {
        return Arrays.stream(c.getAnnotationsByType(Name.class))
                .findAny()
                .map(Name::value)
                .orElseThrow(() -> new AssertionError("Не найдены аннотации GalenPage.Name в класса " + c.getClass().getName()));
    }

    public void write(Object object) {
        scenario.write(String.valueOf(object));
    }

    public Scenario getScenario() {
        return scenario;
    }
}
