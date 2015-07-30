package com.explore.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.explore.model.HelpModule;
import com.explore.model.HibernateUtil;

public class HelpModuleController extends AbstractController {

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
	public String getInstructionalText(String pageName) {
		
		//Mock database for help message.
		HelpModule mockHelpModule = mock(HelpModule.class);
		mockHelpModule.setPageTitle(pageName);
		String msg = "This is the help message from the server for the " + pageName + " page.";
		when(mockHelpModule.getHelpMessage()).thenReturn(msg);
		
//		return mockHelpModule.getHelpMessage();

		
		//Hibernate session for database interaction
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
		
//		// Retrieve help message given the page title
//		List result = session.createQuery("from HELPMESSAGES").list();
//		session.getTransaction().commit();
		
		
//		for(int i = 0; i < result.size(); i++) {
//			HelpModule hm = (HelpModule) result.get(i);
//			System.out.println("Help " + i + ": " + hm.getPageTitle() + 
//								", " + hm.getHelpMessage() + "\n");
//		}
		
//		return "msg from servlet";
		return mockHelpModule.getHelpMessage();
		
	}
}
