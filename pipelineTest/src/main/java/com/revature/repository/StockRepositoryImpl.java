package com.revature.repository;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Stock;
import com.revature.util.SessionFactory;

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
			stock = s.createNativeQuery("SELECT * FROM \"StockProj\".stockpage left join \"StockProj\".stocktable ON stockpageId=stockId WHERE stockportfolioId = "+id, Stock.class).getResultList();

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		return stock;
	}
}
