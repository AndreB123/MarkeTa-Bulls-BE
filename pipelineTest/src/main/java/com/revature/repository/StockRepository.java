package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Stock;

/*
 * The StockRepository listing the methods that will be implemented in the 
 * StockRepositoryImpl. 
 * 
 */
@Repository("sr")
public interface StockRepository {

	public Stock getStockById(int id);		
	public Stock updateStock(int amount);
	
	public Stock removeStock(int id);
	public List<Stock> getAllStocks(int id);
	Stock insertStock(double purchaseprice, String symbol, int amount, int portid);


}
