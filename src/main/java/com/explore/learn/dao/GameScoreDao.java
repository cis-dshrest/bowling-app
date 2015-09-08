package com.explore.learn.dao;

import java.util.List;

import com.explore.learn.model.GameScore;

public interface GameScoreDao {
	
	GameScore findbyGameName(String gameTitle);
	
	void saveGameScore(GameScore gs);
	
	void deleteByGameName(String gameTitle);
	
	List<GameScore> findAllGameScores();
}
