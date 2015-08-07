package com.explore.learn.controller;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.explore.learn.model.HelpModule;
import com.explore.learn.service.HelpModuleService;


@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	HelpModuleService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String listHelpMessage(ModelMap model) {

		List<HelpModule> hmList = service.findAllEmployees();
		model.addAttribute("employees", hmList);
		return "home";
	}
	
	@RequestMapping(value = { "/help" }, method = RequestMethod.GET)
	public void newEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		System.out.println("what is title?");
		System.out.println("the page title is: " + title);
		
		HelpModule hm = service.findHelpModuleByPageTitle(title);
		System.out.println("what is hm?");
		if (hm == null) {
			System.out.println("hm is null");
		}
		else {
			System.out.println("helpmodule is: " + hm.getHelpMessage());
		}
		
		// Send response back		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(hm.getHelpMessage());
		out.close();

	}
	
	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String about(ModelMap model) {
		return "about";
	}
	@RequestMapping(value = { "/signIn" }, method = RequestMethod.GET)
	public String signIn(ModelMap model) {
		
		return "signIn";
	}
	


}
