package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(HttpServletRequest req, HttpServletResponse resp);

	//public Stock getStockById(HttpServletRequest req, HttpServletResponse resp);
	public Stock updateStock(HttpServletRequest req, HttpServletResponse resp);
	public Stock insertStock(int id, String symbol, int amount, double price);
	public Stock removeStock(HttpServletRequest req, HttpServletResponse resp);
	String getStockById(int id);

	//public Stock getStockById(HttpServletRequest req, HttpServletResponse resp);
	

}
