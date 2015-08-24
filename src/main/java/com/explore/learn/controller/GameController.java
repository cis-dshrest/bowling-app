package com.explore.learn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.explore.learn.model.User;
import com.explore.learn.service.UserService;

@Controller
@RequestMapping("/user/game")
public class GameController {

	@Autowired
	UserService userService;

	
	/** 
	 * Show list of users to add to the game. Remove the current user from
	 * the list because they are the creator and are automatically
	 * added to the players list.
	 * 
	 */
	@RequestMapping(value = {"/new" }, method = RequestMethod.GET)
	public String createGame(HttpSession session, ModelMap model) {
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("username", username);
				
		List<User> userList = userService.findAllUsers();
		removeUser(username, userList);
		model.addAttribute("users", userList);
		
		return "creategame";
	}
	
	/**
	 * This method adds the current user and other user selected by the current user 
	 * in the user interface. @see gameview.jsp for the frontend.
	 * 
	 * @return Game UI
	 */
	@RequestMapping(value = {"/view" }, method = RequestMethod.GET)
	public String viewGame(HttpServletRequest request, 
	        HttpServletResponse response, HttpSession session, ModelMap model) {
		
		String gameTitle = (String) request.getParameter("gameTitle");
		model.addAttribute("gameTitle", gameTitle);
		
		String[] players = request.getParameterValues("addUser");
		
		
		//add game UI instance for each player
		List<User> userList = new ArrayList<User>();
		
		// First add current user. Then add "friends" selected by this user.
		String currentUsername = (String) session.getAttribute("username");
		userList.add(userService.findByUsername(currentUsername));
		
		if (players != null) {
			for(String player : players) {
				userList.add(userService.findByUsername(player));
			}
		}
		model.addAttribute("players",userList);
		
		return "gameview";
	}
	
	public void removeUser(String username, List<User> userList) {
		for ( User u : userList) {
			if (u.getUsername().equals(username)) {
				userList.remove(u);
				break;
			}
		}
	}
}
