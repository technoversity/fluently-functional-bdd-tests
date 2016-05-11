package org.fluent.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features", format = { "json:target/functional-tests.json" }, tags = { "~@Ignore" } )
public class RunFunctionalTest {

}
