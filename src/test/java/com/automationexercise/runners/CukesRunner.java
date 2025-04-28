package com.automationexercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com.automationexercise.stepDefs",
        tags = "@login",
        dryRun = false,
        monochrome = true
)
public class CukesRunner {
}
