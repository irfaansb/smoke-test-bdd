package com.bdd.smoke.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty" ,"html:build/reports/tests/test/cucumber.html" ,
        "json:build/reports/tests/test/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.bdd.smoke.test", tags = {"@SmokeTest"})


public class CucumberTest {
}
