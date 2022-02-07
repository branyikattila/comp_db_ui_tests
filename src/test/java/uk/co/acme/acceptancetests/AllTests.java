package uk.co.acme.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "uk.co.acme" }, features = "src/test/resources/features", plugin = { "json:target/cucumber-reports/cucumber.json" }, tags = { "@complete,@accepted" })
public class AllTests {
}
