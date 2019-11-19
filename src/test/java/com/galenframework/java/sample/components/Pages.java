package com.galenframework.java.sample.components;

import com.codeborne.selenide.Selenide;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.Map;

public class Pages {
    private Map<String, GalenPage> pages;

    public Pages() {
        pages = Maps.newHashMap();
    }


    public GalenPage get(String pageName) {
        return Selenide.page(getPageFromPagesByName(pageName)).initialize();
    }

    public <T extends GalenPage> T get(Class<T> clazz, String name) {
        GalenPage page = Selenide.page(getPageFromPagesByName(name)).initialize();

        if (!clazz.isInstance(page)) {
            throw new IllegalStateException(name + " page is not a instance of " + clazz + ". Named page is a " + page);
        }
        return (T) page;
    }

    private Map<String, GalenPage> getPageMapInstanceInternal() {
        return pages;
    }

    private GalenPage getPageFromPagesByName(String pageName) throws IllegalArgumentException {
        GalenPage page = getPageMapInstanceInternal().get(pageName);
        if (page == null)
            throw new IllegalArgumentException(pageName + " page is not declared in a list of available pages");
        return page;
    }

    public <T extends GalenPage> void put(String pageName, T page) throws IllegalArgumentException {
        if (page == null)
            throw new IllegalArgumentException("Была передана пустая страница");
        pages.put(pageName, page);
    }

    public static <T extends GalenPage> T getPage(Class<T> clazz, boolean checkIfElementsAppeared) {
        T page = Selenide.page(clazz);
        if (checkIfElementsAppeared) {
            page.initialize().isAppeared();
        }
        return page;
    }

    @SneakyThrows
    public void put(String pageName, Class<? extends GalenPage> page) {
        if (page == null)
            throw new IllegalArgumentException("Была передана пустая страница");
        Constructor<? extends GalenPage> constructor = page.getDeclaredConstructor();
        constructor.setAccessible(true);
        GalenPage p = page.newInstance();
        pages.put(pageName, p);
    }


}
