package com.explore.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * Testing the UIController class with headless selenium web driver.
 * The test will be performed on the server. 
 * 
 * @author 577654
 *
 */
public class UIControllerTest {
	
	static String baseUrl = "https://52.21.160.142/Exploration/";
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		driver = new HtmlUnitDriver();
		driver.get(baseUrl);
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		driver.close();
	}
	
	
	@Test
	public void testTitle() {
		assertEquals(driver.getTitle(), "Home");
	}
	
	@Test
	public void testFollowLinkAbout() {
		driver.navigate().to(baseUrl+"about");
		assertEquals(driver.getTitle(), "About");
	}
	
	@Test
	public void testFollowLinkLogin() {
		driver.get(baseUrl+"login");
		assertEquals(driver.getTitle(), "Sign In");
	}
	
	@Test
	public void testGoBack() {
		driver.navigate().back();
		assertEquals(driver.getTitle(), "About");
	}
	
	
}
