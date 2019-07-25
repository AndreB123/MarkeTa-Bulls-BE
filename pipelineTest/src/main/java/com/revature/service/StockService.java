package com.revature.service;

import java.util.List;

import com.revature.model.Stock;

public interface StockService {


	
	// Stock getStockById(int id);

	public Stock insertStock(int id, String symbol, int amount, double price);

	// Stock getStockById(HttpServletRequest req, HttpServletResponse resp);
	public Stock getStockById(int id);

	Stock updateStock(int amount);

	public Stock removeStock(int id);

	List<Stock> getAllStocks(int id);

}
