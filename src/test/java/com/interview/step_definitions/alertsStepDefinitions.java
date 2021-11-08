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
    String alertButton;

    @Given("user is on javascript alerts page")
    public void userIsOnJavascriptAlertsPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

//    @When("user clicks for {string}")
//    public void userClicksFor(String string) {
////
//        WebElement element = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'"+string+"')]"));
//        BrowserUtils.clickOnElement(element);
//
//
//
//
//    }


    @When("user clicks OK")
    public void useClicksOk() {

        alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }


    @When("user clicks cancel")
    public void userClicksCancel() {
        alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
    }

    @When("user clicks for JS Prompt")
    public void userClicksForJSPrompt()  {
//        BrowserUtils.clickWithJS(alertsPage.promptAlertButton);
        BrowserUtils.clickOnElement(alertsPage.promptAlertButton);
    }


    @When("user clicks for JS Confirm")
    public void userClicksForJSConfirm() {
        BrowserUtils.clickOnElement(alertsPage.confirmationAlertButton);
    }

    @When("user clicks for {string}")
    public void userClicksFor(String arg0) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'"+arg0+"')]"));
        alertButton = arg0;
        BrowserUtils.clickOnElement(element);
        alert = Driver.getDriver().switchTo().alert();


    }

      @Then("Message should say {string}")
    public void messageShouldSay(String arg0) {
          Assert.assertEquals(arg0, alertsPage.resultMessage.getText());
    }

    @And("user type {string}")
    public void userType(String arg0) {
        alert = Driver.getDriver().switchTo().alert();
        if(!arg0.isEmpty()){
            alert.sendKeys(arg0);
        }

    }

    @And("user clicks {string}")
    public void userClicks(String arg0) {
        alert = Driver.getDriver().switchTo().alert();
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


//    @And("Message should say {string}")
//    public void messageShouldSay(String arg0) {
//        Assert.assertEquals(alertsPage.resultMessage.getText(),arg0);
//
//    }


}
