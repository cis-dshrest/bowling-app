package com.test.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SmokeTestSteps extends Steps {
	private String pageName;
	private String nextPage;
	private String pageContent;
	
	WebDriver driver;
	
	public SmokeTestSteps() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/LetsExplore/");
	}

	@Given( "a user is on the page Home")
	public void getPageValue(String page){
		System.out.println("homepage:");
		pageName = "Home";
	}
	@When("the user clicks the link About")
	public void getLinkValue(String link){
		nextPage = link;
	}
	@Then("the page shoudl read About")
	public void correctPage(String page, String newPageText){
		System.out.println("done");
//		if(!(pageContent.equals(newPageText))){
//			throw new RuntimeException("pageContent is" + pageContent + " but should be " + newPageText);
//		}
//		else
//			System.out.println("All Clear");
		
	}
}
