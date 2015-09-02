package com.explore.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.explore.learn.dao.GameScoreDao;
import com.explore.learn.model.GameScore;

@Service("gameScoreService")
@Transactional
public class GameScoreServiceImpl implements GameScoreService {
	
	@Autowired
	private GameScoreDao dao;

	@Override
	public GameScore findbyGameName(String gameTitle) {
		return dao.findbyGameName(gameTitle);
	}

	@Override
	public void saveGameScore(GameScore gs) {
		dao.saveGameScore(gs);
		
	}

	@Override
	public void deleteByGameName(String gameTitle) {
		dao.deleteByGameName(gameTitle);
	}

	@Override
	public List<GameScore> findAllGameScores() {
		return dao.findAllGameScores();
	}

}
