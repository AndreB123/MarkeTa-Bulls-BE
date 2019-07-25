package com.revature.web;

import java.util.List;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id);
	public Stock insertStock(int id, String symbol, int amount, double price);
	String getStockById(int id);
	public Stock updateStock(int amount);
	public Stock removeStock(int id);

}
