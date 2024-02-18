package com.cucumber.cucumber.zephyr.project.steps;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class ExampleSteps {

    @Inject
    private WebDriver webDriver;

    @Given("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) {
    	webDriver.findElement(By.id("APjFqb")).sendKeys("test automation");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Then("^I google should show me results!$")
    public void i_google_should_show_me_results() {
    }
}