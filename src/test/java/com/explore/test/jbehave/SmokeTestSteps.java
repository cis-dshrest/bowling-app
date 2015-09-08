package com.explore.test.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SmokeTestSteps extends Steps {
	private String pageTitle;
	private String baseUrl ;
	
	WebDriver driver;

	public SmokeTestSteps() {
		System.getProperty("java.class.path");
	}
	
	@Given( "a user is on the page Home")
	public void getPageValue(String page){
		
		baseUrl = "http://localhost:8080/Exploration/";
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		System.out.println("smoke test steps.");
		
		this.pageTitle = driver.getTitle();
		
	}
	@When("the user clicks the page About")
	public void getLinkValue(String link){
		driver.get(baseUrl+"About");
	}
	@Then("the page should read About")
	public void correctPage(){		
		assert(pageTitle.equalsIgnoreCase("About"));
	}
}
