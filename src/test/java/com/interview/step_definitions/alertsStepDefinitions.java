package com.interview.step_definitions;

import com.interview.pages.AlertsPage;
import com.interview.utils.BrowserUtils;
import com.interview.utils.ConfigurationReader;
import com.interview.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class alertsStepDefinitions {
    AlertsPage alertsPage = new AlertsPage();
    Alert alert = null;


    @Given("user is on javascript alerts page")
    public void userIsOnJavascriptAlertsPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("user clicks OK")
    public void useClicksOk() {

        alert.accept();

    }


    @When("user clicks cancel")
    public void userClicksCancel() {
        alert.dismiss();
    }


    @When("user clicks for {string}")
    public void userClicksFor(String arg0) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'" + arg0 + "')]"));
        BrowserUtils.clickOnElement(element);
        alert = Driver.getDriver().switchTo().alert();


    }


    @And("user type {string}")
    public void userType(String arg0) {
        if (!arg0.isEmpty()) {
            alert.sendKeys(arg0);
        }

    }

    @And("user clicks {string}")
    public void userClicks(String arg0) {
        if (arg0.equals("OK")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    @And("alert should say {string}")
    public void alertShouldSay(String arg0) {
        Assert.assertEquals(arg0, alert.getText());
    }


    @Then("result message should be {string}")
    public void resultMessageShouldBe(String arg0) {
        Assert.assertEquals(arg0, alertsPage.resultMessage.getText());
    }


}
