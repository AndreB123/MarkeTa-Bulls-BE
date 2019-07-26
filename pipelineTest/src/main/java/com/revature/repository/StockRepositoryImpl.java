package com.revature.repository;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	public void updateStock(int amount, int id) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;
		Session s2 = null;
		Transaction tx2 = null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = s.get(Stock.class, id);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		int remain = x.getAmount() - amount;
		if(remain <= 0) {
			removeStock(id);
			return;
		}
		try {
			s2 = SessionFactory.getSession();
			tx2 = s2.beginTransaction();
			x.setAmount(remain);
			s2.update(x);
			tx2.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx2.rollback();
		}finally {
			s2.close();
		}
		return;
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
	public void removeStock(int id) {
		Stock x = null;
		Session s = null;
		Transaction tx = null;
		Session s2 = null;
		Transaction tx2 = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = s.get(Stock.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		try {
			s2 = SessionFactory.getSession();
			tx2 = s2.beginTransaction();
			s2.delete(x);
			tx2.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx2.rollback();

		} finally {
			s2.close();
		}
		return;
	}

}
