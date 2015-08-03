package com.explore.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelpModuleDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
    
    public List<HelpModule> selectAll() {
    	Session session = getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Criteria criteria = session.createCriteria(HelpModule.class);
    	List<HelpModule> helpMsgs = (List<HelpModule>) criteria.list();
    	session.getTransaction().commit();
    	return helpMsgs;
    }

}