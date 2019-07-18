package com.revature.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
	private static org.hibernate.SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", System.getenv("bankingDatabasePath"))
					.setProperty("hibernate.connection.username", System.getenv("bankingUser"))
					.setProperty("hibernate.connection.password", System.getenv("bankingPassword"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
