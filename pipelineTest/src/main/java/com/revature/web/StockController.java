package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id);

	public Stock insertStock(double price, String symbol, int amount, int id);
	String getStockById(int id);
	public Stock updateStock(int amount);
	public Stock removeStock(int id);

}
