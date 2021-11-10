package com.interview.pages;

import com.interview.utils.ConfigurationReader;
import com.interview.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy (xpath = "//div[@class='alert alert-danger']//li")
    private WebElement errorMessage;

    @FindBy(id = "email")
    private WebElement username;
    @FindBy(id = "passwd")
    private WebElement password;


    public void login() {
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }




}
