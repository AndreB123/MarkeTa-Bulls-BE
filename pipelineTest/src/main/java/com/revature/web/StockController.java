package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id);
	public Stock insertStock(int id, String symbol, int amount, double price);
	String getStockById(int id);
	public void updateStock(String amount, String stockId, String user, String balance);
	public Stock removeStock(int id);

}
