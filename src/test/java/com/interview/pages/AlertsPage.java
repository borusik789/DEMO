package com.interview.pages;

import com.interview.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    public AlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    public WebElement alertButton;

    @FindBy(xpath = "//*[text()='Click for JS Confirm']")
    public WebElement confirmationAlertButton;

    @FindBy(xpath = "//*[text()='Click for JS Prompt']")
    public WebElement promptAlertButton;

    @FindBy(id="result")
    public WebElement resultMessage;









}
