package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.model.Stock;
import com.revature.util.SessionFactory;


@Repository("sr")
public class StockRepositoryImpl implements StockRepository {

	@Override
	public List<Stock> getAllStocks() {
		List<Stock> stock = new ArrayList<>();
		Session s = null;

		try {
			s = SessionFactory.getSession();
			stock = s.createQuery("FROM Stock", Stock.class).getResultList();

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			s.close();
		}
		return stock;
	}

	@Override
	public Stock getStockById(int id) {
		Stock x = null;
		Session s = null;

		try {
			s = SessionFactory.getSession();
			x = s.load(Stock.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			s.close();
		}
		return x;
	}
}
