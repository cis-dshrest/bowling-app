package com.explore.learn.service;

import java.util.List;

import com.explore.learn.model.GameScore;

public interface GameScoreService {
	
	GameScore findbyGameName(String gameTitle);
	
	void saveGameScore(GameScore gs);
	
	void deleteByGameName(String gameTitle);
	
	List<GameScore> findAllGameScores(); 
	
}
