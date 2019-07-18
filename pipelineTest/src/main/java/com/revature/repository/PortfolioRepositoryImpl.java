package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;
import com.revature.util.SessionFactory;



@Repository("pr")
public class PortfolioRepositoryImpl implements PortfolioRepository {

	public List<Portfolio> getAllPortfolios() {
	List<Portfolio> portfolio = new ArrayList<>();
	Session s = null;

	try {
		s = SessionFactory.getSession();
		portfolio = s.createQuery("FROM Portfolio", Portfolio.class).getResultList();

	} catch (HibernateException e) {
		e.printStackTrace();
	} finally {
		s.clear();
	}
	return portfolio;
	}

	@Override
	public Portfolio getPortfolioById(int id) {
		Portfolio p = null;
		Session s = null;

		try {
			s = SessionFactory.getSession();
			p = s.get(Portfolio.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return p;
	}


	@Override
	public void insertPortfolio(Portfolio p) {
		Session s = null;
		Transaction tx = null;

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
	}

	@Override
	public void deletePortfolio(Portfolio p) {
		Session s= null;
		Transaction tx =null;
		
		try {
			s= SessionFactory.getSession();
			tx= s.beginTransaction();
			s.delete(p);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}
}
	
	




