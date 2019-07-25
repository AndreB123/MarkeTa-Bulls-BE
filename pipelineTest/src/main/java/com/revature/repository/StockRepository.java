package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Stock;

/*
 * 
 */
@Repository("sr")
public interface StockRepository {

	public Stock getStockById(int id);		
	public Stock updateStock(int amount);
	public Stock insertStock(int id, String symbol, int amount, double price);
	public Stock removeStock(int id);
	public List<Stock> getAllStocks(int id);


}
