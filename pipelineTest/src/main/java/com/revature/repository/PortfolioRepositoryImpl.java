package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;
import com.revature.model.Stock;
import com.revature.util.SessionFactory;

/*
 * Implemented methods from declared methods within PortfolioRepository. 
 */

@Repository("pr2")
public class PortfolioRepositoryImpl implements PortfolioRepository {

	public List<Portfolio> getAllPortfolios(String username) {
	List<Portfolio> portfolios = new ArrayList<>();
	Session s = null;
	Transaction tx = null;

	try {
		s = SessionFactory.getSession();
		tx = s.beginTransaction();
		portfolios = s.createNativeQuery("Select * from \"StockProj\".portfolio where portusername = '" + username + "'", Portfolio.class).getResultList();
		tx.commit();
	} catch (HibernateException e) {
		e.printStackTrace();
		tx.rollback();
	} finally {
		s.close();
	}
	
	System.out.println(portfolios);
	return portfolios;
	}

	@Override
	public Portfolio getPortfolioById(int id) {
		Portfolio p = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = SessionFactory.getSession();
			tx= s.beginTransaction();
			//p = s.createNativeQuery("SELECT * ";Portfolio.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return p;
	}


	@Override
	public Portfolio insertPortfolio(String user, String portname) {
		Portfolio j = null;
		Session s = null;
		Transaction tx = null;
		Portfolio p = new Portfolio(1, portname, 0, user);
		System.out.println(p);

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return j;
	}

//	@Override
//	public Portfolio deletePortfolio(int id) {
//		Portfolio j = null;
//		Session s = null;
//		Transaction tx = null;
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			j = (Portfolio) s.createNativeQuery("DELETE FROM portfolio WHERE portfolioId=?", Portfolio.class).getResultList();
//
//			tx.commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//
//		} finally {
//			s.close();
//		}
//		return j;
//}
}
	
	




