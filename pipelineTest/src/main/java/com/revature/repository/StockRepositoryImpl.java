package com.revature.repository;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Stock;
import com.revature.util.SessionFactory;

/*
 * Implemented methods from declared methods within StockRepository. This is where all our 
 * Stock related SQL statements are located. We have SQL statments for getting
 * all stock, getting stock by ID, *inserting, updating and removing stocks. . 
 *
 */

@Repository("sr2")
public class StockRepositoryImpl implements StockRepository {

	@Override
	public Stock getStockById(int id) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = s.load(Stock.class, id);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return x;
	}

	@Override
	public List<Stock> getAllStocks(int id) {
		List<Stock> stock = new ArrayList<>();
		Session s = null;
		Transaction tx = null;

		System.out.println("hit");

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			stock = s.createNativeQuery(
					"SELECT * FROM \"StockProj\".portfolio left join \"StockProj\".stocktable ON portId=portfolioId where portId="
							+ id,
					Stock.class).getResultList();

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return stock;
	}

	@Override
	public Stock updateStock(int amount) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;

		System.out.println("hit");

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = (Stock) s.createNativeQuery("UPDATE stocktable set amount= " + amount + " where portId=portfolioId",
					Stock.class).getResultList();

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return x;
	}

	@Override
	public Stock insertStock(double purchaseprice, String symbol, int amount, int portid) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;
		Stock xx= new Stock(1, purchaseprice, symbol, amount, portid); 

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();                                                           
			s.save(xx);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return x;
	}

	@Override
	public Stock removeStock(int id) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = (Stock) s.createNativeQuery("DELETE FROM stocktable WHERE stockID=" + id, Stock.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return x;
	}

}
