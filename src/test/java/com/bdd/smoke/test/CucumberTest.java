package com.bdd.smoke.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","pretty:target/cucumber-html-report.html"},
        features = "src/test/resources/features",
        glue = "com.bdd.smoke.test", tags = {"@SmokeTest"})


public class CucumberTest {
}
