package com.galenframework.java.sample.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.WebDriverRunner.url;

public class LinkUtils {
    private List<String> links;

    public List<String> getLinks() {
        return links;
    }

    public LinkUtils from(ElementsCollection elements) {
        links = new ArrayList<>();

        for (SelenideElement element : elements) {
            try {
                String url = getURL(element);
                if (!url.equals("")) {
                    links.add(url);
                }
            } catch (Exception e) {
                System.out.println(element.toString() + "does not have 'href' attribute");
            }
        }

        System.out.println("Got links on the page = " + links.size());
        return this;
    }

    public String getURL(SelenideElement selenideElement) {
        return selenideElement.attr("href");
    }

    public LinkUtils getUnique() {
        links = links.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique links amount = " + links.size());
        return this;
    }

    public LinkUtils getWithoutAnchor() {
        String currentPageUrl = url() + "#";
        links = links.stream().filter(p -> !p.contains(currentPageUrl)).collect(Collectors.toList());
        System.out.println("Without # Anchor links amount = " + links.size());
        return this;
    }

    public LinkUtils getInternalOnly() {
        String currentPageUrl = url();

        try {
            URL url = new URL(currentPageUrl);
            String currentPageDomain = url.getHost();
            links = links.stream().filter(p -> p.contains(currentPageDomain)).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Could not get domain from the link " + url());
        }

        return this;
    }
}
