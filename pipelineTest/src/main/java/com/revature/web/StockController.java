package com.revature.web;

import java.util.List;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id);
	public Stock insertStock(String id, String symbol, String amount, String price);
	String getStockById(int id);
	public Stock updateStock(int amount);
	public Stock removeStock(int id);

}
