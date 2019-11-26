package com.galenframework.java.sample.stepDefinitions;

import com.galenframework.java.sample.config.GafConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GAFAPIStepDefinitions {

    private Response response;
    private RequestSpecification request;

//    @Given("^an GAF base url with url to API services$")
//    public void urlIsDefined() throws Throwable {
//        request = given().
//                baseUri(GafConfiguration.HOME_UA_PROD).
//                basePath(GafConfiguration.HOME_UA_PROD);
//    }
//
//    @Given("^request have the following parameters$")
//    public void requestContentTypeProductsSearchTextRoofPageNo(Map<String, String> parameters) throws Throwable {
//        request.params(parameters);
//    }
//
//    @When("^method POST$")
//    public void methodPOST() throws Throwable {
//        System.out.println("request: " + request.log().all());
//        response = request.post();
//        System.out.println("response: " + response.prettyPrint());
//    }
//
//    @Then("^status (\\d+)$")
//    public void status(int status) throws Throwable {
//        assertThat(response.getStatusCode()).isEqualTo(status);
//    }
//
//    @Then("^assert response '(.*)' length == (\\d+)$")
//    public void assertResponseResultsItemsLength(String jsonPath, int expectedLength) throws Throwable {
//        JsonPath jsonResponse = response.jsonPath();
//        assertThat(((ArrayList) jsonResponse.getList(jsonPath).get(0)).size()).isEqualTo(expectedLength);
//    }

//    @Then("^assert that each search response have '(.*)' in '(.*)'$")
//    public void assertThatEachSearchResponseHaveKeywordInTitle(String keyword, String responseCategory) throws Throwable {
//        // case json response to POJO
//        Gson gson = new GsonBuilder().create();
//        SearchResults searchResults = gson.fromJson(response.getBody().prettyPrint(), SearchResults.class);
//
//        // verification that title of each response contains keyword
//        if ("title".equals(responseCategory)) {
//            List<String> titlesList = searchResults.getResults().stream()
//                    .flatMap(result -> result.getItems().stream())
//                    .map(Item::getTitle).
//                            collect(Collectors.toList());
//
//            assertThat(titlesList).allMatch(title ->
//                    StringUtils.containsIgnoreCase(title, keyword));
//        } else {
//            Assertions.fail("Response category '" + responseCategory + "' is not supported");
//        }
//    }
}
