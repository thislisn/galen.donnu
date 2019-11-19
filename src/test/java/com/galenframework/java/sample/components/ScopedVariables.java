package com.galenframework.java.sample.components;

import com.google.common.collect.Maps;

import java.util.Map;

public class ScopedVariables {
    private Map<String, Object> variables = Maps.newHashMap();

    public void put(String name, Object value) {
        variables.put(name, value);
    }

    public Object get(String name) {
        return variables.get(name);
    }

    public void clear() {
        variables.clear();
    }

    public Object remove(String key) {
        return variables.remove(key);
    }
}
