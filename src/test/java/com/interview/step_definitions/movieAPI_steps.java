package com.interview.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class movieAPI_steps {



    @Given("The Open Movie Database")
    public void the_open_movie_database() {
        System.out.println("We are on a The Open Movie Database");
    }


    @DisplayName("Test Search Movie or OpenMovieDB Test")
    @Test
    @Then("user can verify API calls for different movies")
    public void user_can_verify_api_calls_for_different_movies() {

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
