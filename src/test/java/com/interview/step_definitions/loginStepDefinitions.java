package com.interview.step_definitions;

import com.interview.pages.LoginPage;
import com.interview.utils.ConfigurationReader;
import com.interview.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefinitions {
    LoginPage login = new LoginPage();

    @When("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
       login.login();

    }


    @Then("user should see {string} page")
    public void userShouldSeePage(String arg0) {
        Assert.assertEquals(Driver.getDriver().getTitle(),arg0);
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url1"));

    }


    @When("user logs in with {string} username and {string} password")
    public void userLogsInWithUsernameAndPassword(String arg0, String arg1) {
        login.login(arg0, arg1);


    }

    @Then("user verifies that {string} message is displayed")
    public void userVerifiesThatMessageIsDisplayed(String arg0) {
        Assert.assertEquals(login.getErrorMessage().getText(),arg0 );
    }
}
