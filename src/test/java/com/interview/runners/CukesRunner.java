package com.interview.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "timeline:target/timeline-report",
                "rerun:target/rerun.txt",

        },

        features = {"src/test/resources/features"},
        glue = "com/interview/step_definitions",
        dryRun = false,
        tags = "@UI or @MovieAPI",
        publish = true


)


public class CukesRunner {
}
