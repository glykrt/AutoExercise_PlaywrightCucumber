package com.automationexercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failedRerun.txt",
        glue = "com.automationexercise.stepDefs",
        plugin = {
                "pretty",
                "html:target/failed-cucumber-reports.html",
                "json:target/failed-cucumber.json"
        },
        monochrome = true
)
public class FailedTestRunner {
}
