package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id, String symbol, int amount, double price);

	public Stock updateStock(int amount);

	public Stock insertStock(int id, String symbol, int amount, double price);

	public Stock removeStock(int id);

	String getStockById(int id);

}
