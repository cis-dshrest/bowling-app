package com.explore.learn.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.explore.learn.model.HelpModule;
import com.explore.learn.service.HelpModuleService;

public class HelpModuleController extends AbstractController {

	@Autowired
	HelpModuleService service;
	
	@Autowired
	MessageSource messageSource;

	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
		ModelAndView modelandview = new ModelAndView("help");
//		modelandview.addObject("helpBody", "This will be the help page!");
		
		// Get the parameter from ajax request from client.
		String title = request.getParameter("title");
		System.out.println("the page title is: " + title);
		
		// Get data from the database.
		String msg = getInstructionalText(title);
		
		// Send response back		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();

		return modelandview;
	}
	

	
	/**
	 * Return a help message to the help module from a mysql database.
	 * It reads the title page and determines the message to be returned.
	 * 
	 * @param pageName title of the current page
	 * @return 		   the help message for the page
	 */
	public String getInstructionalText(String pageTitle) {
		
		//Mock database for help message.
//		HelpModule mockHelpModule = mock(HelpModule.class);
//		mockHelpModule.setPageTitle(pageTitle);
//		String msg = "This is the help message from the server for the " + pageTitle + " page.";
//		when(mockHelpModule.getHelpMessage()).thenReturn(msg);
		
//		return mockHelpModule.getHelpMessage();

		
		//Hibernate session for database interaction
		HelpModule hm = service.findHelpModuleByPageTitle(pageTitle);
		
		
		System.out.println(hm.getHelpMessage());
		return hm.getHelpMessage();
		

//		for(int i = 0; i < result.size(); i++) {
//			HelpModule hm = (HelpModule) result.get(i);
//			System.out.println("Help " + i + ": " + hm.getPageTitle() + 
//								", " + hm.getHelpMessage() + "\n");
//		}
		
//		return "msg from servlet";
//		return mockHelpModule.getHelpMessage();
		
	}
}
