package com.explore.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory; //= buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	

	private static void buildSessionFactory() {

            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
    	    configuration.configure();
    	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
    				configuration.getProperties()).build();
    		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
