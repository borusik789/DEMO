package com.interview.step_definitions;

import com.interview.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import static io.restassured.RestAssured.reset;

/**
 * Hooks name is not reserved. You may name this class in any way.
 * For example: SuiteSetupAndTearDown
 * Hooks triggered based on tags not class name or their location.
 * These methods can be a part of any step definition class.
 * Common practice is to store them in the separate class.
 */
public class Hooks {

//    hook before = @BeforeMethod in TestNG
//    hook after = @AfterMethod in TestNG
//    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//    usually, we just use explicit and fluent waits.

    @Before("@MovieAPI")
    public void setUp() {
    RestAssured.baseURI = "http://www.omdbapi.com";
        System.out.println("BaseURI is setUp");

}

    @After("@MovieAPI")
    public void tearDown() {
        reset();
        System.out.println("tearDown");
    }

    @Before ("@UI")
    public void setup(Scenario scenario) {
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After ("@UI")
    public void tearDown(Scenario scenario) {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test


        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }

//    @BeforeStep
//    public void beforeStep(){
//        System.out.println("I'm before step");
//    }
//    this hook will run only before scenarios with a tag @db

    /**
     * @db Scenario: I don't know but here I'm connecting to DB
     * Given user runs following query "SELECT * ...."
     * <p>
     * order = 0 - to define hooks execution order
     */
    @Before(value = "@db", order = 0)
    public void dbSetup() {
        System.out.println("::: Connecting to the database:::");
    }

    @After("@db")
    public void dbTearDown() {
        System.out.println("::: Disconnecting from the database:::");
    }


}
