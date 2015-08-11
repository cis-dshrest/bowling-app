package com.explore.learn.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.explore.learn.model.HelpModule;
import com.explore.learn.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	public User findByUsername(String username) {
		return getByKey(username);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
		
	}

	@Override
	public void deleteUserByUsername(String username) {
		Query query = getSession().createSQLQuery("delete from user where username = :username");
		query.setString("username", username);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	@Override
	public User findUserByRealName(String first, String last) {
		Criteria criteria = getSession().createCriteria(HelpModule.class);
		criteria.add(Restrictions.eq("firstName", first));
		return (User) criteria.uniqueResult();
	}

}
