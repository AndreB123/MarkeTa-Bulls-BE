package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockService {

	// List<Stock> getAllStocks(int portfolioId);

	List<Stock> getAllStocks(int id);
	// Stock getStockById(int id);

	public Stock insertStock(int id, String symbol, int amount, double price);

	// Stock getStockById(HttpServletRequest req, HttpServletResponse resp);
	public Stock getStockById(int id);

	Stock updateStock(int amount);

	public Stock removeStock(int id);

}
