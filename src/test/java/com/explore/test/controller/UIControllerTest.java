package com.explore.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UIControllerTest {
	
	static String baseUrl = "http://localhost:8080/Exploration/";
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		driver = new FirefoxDriver();
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
		assertEquals(driver.getTitle(), "Home");
	}
	
	
}
