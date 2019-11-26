package com.galenframework.java.sample.utils;


import com.galenframework.java.sample.page.context.ScenarioContext;
import cucumber.api.Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportWriter {

    public void writeCollectionComparisonReport(List<String> allLinksReplacedDomain, List<String> allLinksProduction) {
        // List with all possible links
        List<String> allLinks = new ArrayList<>();
        allLinks.addAll(allLinksReplacedDomain);
        allLinks.addAll(allLinksProduction);

        // Make list of unique links
        allLinks.stream().distinct().collect(Collectors.toList());

        // generating HTML snapshot
        StringBuilder htmlReportTable = new StringBuilder();
        htmlReportTable.append(
                "<table cellpadding=\"5\" width=\"100%\" " +
                        "style= \"font-size: 14px; table-layout: fixed; word-wrap: break-word;\">" +
                        "<tbody>" +
                        "<tr style=\"background-color: #66CCEE\">" +
                        "<th width=\"8%\">Status</th>" +
                        "<th width=\"70%\">Link</th>" +
                        "<th width=\"11%\">Test environment</th>" +
                        "<th width=\"11%\">www.gaf.com</th>" +
                        "</tr>"
        );

        StringBuilder positiveResults = new StringBuilder();
        StringBuilder negativeResults = new StringBuilder();

        for (String link : allLinks) {

            if (allLinksReplacedDomain.contains(link) && allLinksProduction.contains(link)) {
                // adding Passing case
                positiveResults.append("<tr style=\"background-color: #92dd96\">" +
                        "<td style=\"text-align: center; font-family: Arial; font-weight: bold\">" +
                        "Passed</td><td>" +
                        link + "</td><td style=\"text-align: center\">" +
                        allLinksReplacedDomain.contains(link) + "</td><td style=\"text-align: center\">" +
                        allLinksProduction.contains(link) + "</td></tr>"
                );
            } else {
                // adding Failed case
                negativeResults.append("<tr style=\"background-color: #F2928C\">" +
                        "<td style=\"text-align: center; font-family: Arial; font-weight: bold\">" +
                        "Failed</td><td>" +
                        link + "</td><td style=\"text-align: center\">" +
                        allLinksReplacedDomain.contains(link) + "</td><td style=\"text-align: center\">" +
                        allLinksProduction.contains(link) + "</td></tr>"
                );
            }

        }

        htmlReportTable.append(negativeResults);
        htmlReportTable.append(positiveResults);

        htmlReportTable.append("</tbody></table>");

        Scenario scenario = ScenarioContext.get("scenario");
        scenario.embed(htmlReportTable.toString().getBytes(), "text/html");
    }

    public void writeLinkToGalenReport(String galenSpecFile) {
        String htmlLink = "<iframe src=\"../GalenReport/1-" +
                galenSpecFile +
                ".html\" width=\"100%\" height=\"600px\" title=\"Galen Report\"><p>Your browser does not support iframes.</p></iframe>";

        Scenario scenario = ScenarioContext.get("scenario");
        scenario.embed(htmlLink.getBytes(), "text/html");
    }
}
