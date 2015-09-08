package com.explore.learn.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.explore.learn.model.GameScore;

@Repository("gameScoreDao")
public class GameScoreDaoImpl extends AbstractDao<Integer, GameScore> implements GameScoreDao {
	
	@Override
	public GameScore findbyGameName(String gameTitle){
		Criteria criteria = getSession().createCriteria(GameScore.class);
		criteria.add(Restrictions.eq("gameTitle", gameTitle));
		return (GameScore) criteria.uniqueResult();	
	}
	
	@Override
	public void saveGameScore(GameScore gs) {
		persist(gs);
	}
	
	@Override
	public void deleteByGameName(String gameTitle) {
		Query query = getSession().createSQLQuery("delete from gamescores where gameTitle = :gameTitle");
		query.setString("gameTitle", gameTitle);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GameScore> findAllGameScores() {
		Criteria criteria = createEntityCriteria();
		return (List<GameScore>) criteria.list();
	}
	
}
