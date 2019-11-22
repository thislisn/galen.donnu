package com.galenframework.java.sample.page.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();

    public static <T> T get(final String name) {
        final Object object = context.get().get(name);
        return (T) object;
    }

    public static void put(final String name, final Object object) {
        context.get().put(name, object);
    }

    public void init() {
        context.set(new HashMap<>());
    }
}
