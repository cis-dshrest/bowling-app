package com.explore.learn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.explore.learn.model.GameScore;
import com.explore.learn.model.User;
import com.explore.learn.service.GameScoreService;
import com.explore.learn.service.UserService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/user/game")
public class GameController {

	@Autowired
	UserService userService;

	@Autowired
	GameScoreService gameScoreService;
	
	
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
	
	@RequestMapping(value = {"/saveScore" }, method = RequestMethod.POST)
	public void saveScore(HttpServletRequest request, 
	        HttpServletResponse response, @RequestBody String gameScores) throws IOException {
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(gameScores);
		JsonObject game = element.getAsJsonObject();
		
		GameScore gs = new GameScore();
		
		//Get time stamp for unique game name
		String timeStamp = new SimpleDateFormat("-yyyy.MM.dd.HH.mm.ss").format(System.currentTimeMillis());
		
		String gamename = game.get("gameTitle").getAsString() + timeStamp;
		
		gs.setGameTitle(gamename);
		gs.setData(gameScores);
		
		//save the game score to the database
		gameScoreService.saveGameScore(gs);
		
		//send a success message to the ajax caller
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("success");
		out.close();

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
