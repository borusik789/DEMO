package com.interview.step_definitions;

import com.interview.pages.AlertsPage;
import com.interview.utils.BrowserUtils;
import com.interview.utils.ConfigurationReader;
import com.interview.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class alertsStepDefinitions {
    AlertsPage alertsPage = new AlertsPage();
    Alert alert = null;

    @Given("user is on javascript alerts page")
    public void userIsOnJavascriptAlertsPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user clicks on alert button")
    public void userClicksOnAlertButton() {
        BrowserUtils.clickOnElement(alertsPage.alertButton);
    }
    @Then("user should see alert window with {string} text")
    public void userShouldSeeAlertWindowWithText(String string) {

        Assert.assertTrue(BrowserUtils.isAlertPresent());
        alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),string);

    }
    @When("user clicks OK")
    public void useClicksOk() {
        alert.accept();


    }
    @Then("alert should disappear")
    public void alertShouldDisappear() {
        Assert.assertFalse(BrowserUtils.isAlertPresent());

    }

    @When("user clicks cancel")
    public void userClicksCancel() {
        alert.dismiss();
    }

    @When("user clicks on prompt alert button")
    public void userClicksOnPromptAlertButton() {
//        BrowserUtils.clickWithJS(alertsPage.promptAlertButton);
        BrowserUtils.clickOnElement(alertsPage.promptAlertButton);
    }

    @When("user type {string}")
    public void userType(String string) {
        String usersText = string;
        alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(string);

    }

    @When("user clicks on confirmation box button")
    public void userClicksOnConfirmationBoxButton() {
        BrowserUtils.clickOnElement(alertsPage.confirmationAlertButton);
    }


    @Then("Message should say {string}")
    public void messageShouldSay(String arg0) {
        Assert.assertEquals(alertsPage.resultMessage.getText(),arg0);

    }
}
