package com.revature.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
	private static org.hibernate.SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", System.getenv("dburl"))
					.setProperty("hibernate.connection.username", System.getenv("dbusername"))
					.setProperty("hibernate.connection.password", System.getenv("dbpassword"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
