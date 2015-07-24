package com.test.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.explore.controller.HelpModule;

public class HelpModuleTest {
	
	@Mock
	HelpModule dao;
	

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
		
		dao = mock(HelpModule.class);
		when(dao.getHelpMessage("Home")).thenReturn(nameToHelpMessage.get("Home"));
		when(dao.getHelpMessage("About")).thenReturn("This is the About page.");
	}
	
	@Test
	public void getHelpMessage() {
		assertEquals(dao.getHelpMessage("Home"), "This is the Home page.");
		assertEquals(dao.getHelpMessage("About"), "This is the About page.");
	}
}
