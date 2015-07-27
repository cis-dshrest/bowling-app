package com.test.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.explore.controller.HelpMessageController;
import com.explore.model.HelpModule;

public class HelpModuleTest {
	
	@Mock
	HelpMessageController dao;
	

	@Before
	public void create() {		
		
		initMocks(this);
		// Setup hashmap for now. Use hibernate here 
		
		Map<String, String> nameToHelpMessage = new HashMap<String, String>();
		
		nameToHelpMessage.put("Home", "This is the Home page.");
		nameToHelpMessage.put("About", "This is the About page.");
		nameToHelpMessage.put("Admin", "This is the Admin page.");
		nameToHelpMessage.put("New Game", "This is the New Game page.");
		nameToHelpMessage.put("Profile", "This is the Profile page.");
		nameToHelpMessage.put("Sign In", "This is the Sign In page.");
		nameToHelpMessage.put("Sign Out", "This is the Sign Out page.");
		nameToHelpMessage.put("View Game", "This is the View Game page.");
		
		dao = mock(HelpMessageController.class);
		when(dao.getHelpMessage("Home")).thenReturn(nameToHelpMessage.get("Home"));
		when(dao.getHelpMessage("About")).thenReturn(nameToHelpMessage.get("About"));
		when(dao.getHelpMessage("Admin")).thenReturn(nameToHelpMessage.get("Admin"));
		when(dao.getHelpMessage("New Game")).thenReturn(nameToHelpMessage.get("New Game"));
		when(dao.getHelpMessage("Profile")).thenReturn(nameToHelpMessage.get("Profile"));
		when(dao.getHelpMessage("Sign In")).thenReturn(nameToHelpMessage.get("Sign In"));
		when(dao.getHelpMessage("Sign Out")).thenReturn(nameToHelpMessage.get("Sign Out"));
		when(dao.getHelpMessage("View Game")).thenReturn(nameToHelpMessage.get("View Game"));
		
	}
	
	@Test
	public void getHelpMessage() {
		assertEquals(dao.getHelpMessage("Home"), "This is the Home page.");
		assertEquals(dao.getHelpMessage("About"), "This is the About page.");
		assertEquals(dao.getHelpMessage("Admin"), "This is the Admin page.");
		assertEquals(dao.getHelpMessage("New Game"), "This is the New Game page.");
		assertEquals(dao.getHelpMessage("Profile"), "This is the Profile page.");
		assertEquals(dao.getHelpMessage("Sign In"), "This is the Sign In page.");
		assertEquals(dao.getHelpMessage("Sign Out"), "This is the Sign Out page.");
		assertEquals(dao.getHelpMessage("View Game"), "This is the View Game page.");
		
	}
}
