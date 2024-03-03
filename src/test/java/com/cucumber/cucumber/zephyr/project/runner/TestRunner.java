package com.cucumber.cucumber.zephyr.project.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;

public class TestRunner {
	
	public static void main(String []args) {
		
		JUnitCore.main("com.cucumber.cucumber.zephyr.project.acceptancetests.AllTests");
	}

}
