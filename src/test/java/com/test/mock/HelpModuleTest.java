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

import com.explore.controller.HelpModuleController;
import com.explore.model.HelpModule;

public class HelpModuleTest {
	
	@Mock
	HelpModuleController dao;
	

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
		
		dao = mock(HelpModuleController.class);
		when(dao.getInstructionalText("Home")).thenReturn(nameToHelpMessage.get("Home"));
		when(dao.getInstructionalText("About")).thenReturn(nameToHelpMessage.get("About"));
		when(dao.getInstructionalText("Admin")).thenReturn(nameToHelpMessage.get("Admin"));
		when(dao.getInstructionalText("New Game")).thenReturn(nameToHelpMessage.get("New Game"));
		when(dao.getInstructionalText("Profile")).thenReturn(nameToHelpMessage.get("Profile"));
		when(dao.getInstructionalText("Sign In")).thenReturn(nameToHelpMessage.get("Sign In"));
		when(dao.getInstructionalText("Sign Out")).thenReturn(nameToHelpMessage.get("Sign Out"));
		when(dao.getInstructionalText("View Game")).thenReturn(nameToHelpMessage.get("View Game"));
		
	}
	
	@Test
	public void getInstructionalText() {
		assertEquals(dao.getInstructionalText("Home"), "This is the Home page.");
		assertEquals(dao.getInstructionalText("About"), "This is the About page.");
		assertEquals(dao.getInstructionalText("Admin"), "This is the Admin page.");
		assertEquals(dao.getInstructionalText("New Game"), "This is the New Game page.");
		assertEquals(dao.getInstructionalText("Profile"), "This is the Profile page.");
		assertEquals(dao.getInstructionalText("Sign In"), "This is the Sign In page.");
		assertEquals(dao.getInstructionalText("Sign Out"), "This is the Sign Out page.");
		assertEquals(dao.getInstructionalText("View Game"), "This is the View Game page.");
		
	}
}
