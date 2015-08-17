package com.explore.learn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.explore.learn.model.User;
import com.explore.learn.service.UserService;


/**
 * This controller should take care of all the end points for admins.
 * 
 * @author David S.
 * @since  08/17/2015
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/", "/admin" }, method = RequestMethod.GET)
	public String getAdmin(HttpSession session, ModelMap model) {
		String role = (String) session.getAttribute("role");
		if(role.equalsIgnoreCase("admin")) {
			return "forward:/user/profile";
		}
		else {
			return "redirect:/403";
		}
	}
	
	@RequestMapping(value = { "/listusers" }, method = RequestMethod.GET)
	public String listUsers(HttpSession session, ModelMap model) {
		
		String role = (String) session.getAttribute("role");
		
		if(role.equalsIgnoreCase("admin")) {
			//List users
			List<User> userList = userService.findAllUsers();
			model.addAttribute("users", userList);
			return "listUsers";
		}
		else {
			return "redirect:/403";
		}
		
	}
	
	@RequestMapping(value = { "/edit-{username}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String username, ModelMap model) {
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("breadcrumUsername", user.getUsername());
		return "edituser";
	}
	
	@RequestMapping(value = { "/modify" }, method = RequestMethod.POST)
	public String modify(@Valid User user, BindingResult result,
			ModelMap model) {
		
		userService.updateUser(user);
		return "modifyAdminSuccess";
	}
	
	@RequestMapping(value = { "/delete-{username}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username, HttpSession session, ModelMap model) {
		
		
		userService.deleteUserbyUsername(username);
		return listUsers(session, model);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String defaultHandler(HttpSession session, ModelMap model) {
		String role = (String) session.getAttribute("role");
		
		if (role.equalsIgnoreCase("admin")) {
			return "profile";
		}
		else {
			return "redirect:/403";
		}
	}
	
}
