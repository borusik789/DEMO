package com.interview.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class movieApiStepDefinitions {

    @Given("The Open Movie Database")
    public void theOpenMovieDatabase() {
        System.out.println("We are on a The Open Movie Database");
    }

    @Then("user can verify API calls for different movies")
    public void userCanVerifyAPICallsForDifferentMovies() {
        given()
                .queryParam("apiKey", "5b5d0fe8")
                .queryParam("t", "The Orville").
                when()
                .get().prettyPeek().
                then()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("Ratings[0].Source", is("Internet Movie Database"));
    }


}
