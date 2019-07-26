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
	public void updateStock(int amount, int id);
	public void removeStock(int id);

	public List<Stock> getAllStocks(int id);
	public Stock insertStock(double purchaseprice, String symbol, int amount, int portid);


}
