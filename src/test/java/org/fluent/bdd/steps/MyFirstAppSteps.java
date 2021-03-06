package org.fluent.bdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluent.bdd.page.CucumberPage;
import org.fluent.bdd.page.GooglePage;
import org.fluentlenium.adapter.FluentTest;

import java.util.concurrent.TimeUnit;

public class MyFirstAppSteps extends FluentTest {

    private GooglePage googlePage = new GooglePage();

    private CucumberPage cucumberPage = new CucumberPage();

    @Given("^I navigate to Google home page")
    public void I_navigate_to_Google_home_page() throws Throwable {
        googlePage.goToSearchPage();
        googlePage.isAt();
    }

    @When("^I enter the query (.*) and submit page$")
    public void I_enter_the_query_and_submit_page(String query)
            throws Throwable {
        googlePage.submitQuery(query);
    }

    @And("^I click the first link on the results page")
    public void I_click_the_first_link_on_the_results_page()
            throws Throwable {
        googlePage.clickFirstLinkInSearchResults();
    }

    @Then("^I see the cucumber home page with title (.*)$")
    public void I_see_the_cucumber_home_page_with_title(String title)
            throws Throwable {
        //TODO: For now added some delay to cater for Firefox page loading.
        getDefaultDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        cucumberPage.isAt();
    }

}
