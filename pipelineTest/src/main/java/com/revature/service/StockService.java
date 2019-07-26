package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

/*
 * The StockService listing the methods that will be implemented in the 
 * StockServiceImpl. 
 */
public interface StockService {

	public Stock getStockById(int id);
	Stock updateStock(int amount);
	public Stock removeStock(int id);
	List<Stock> getAllStocks(int id);
	Stock insertStock(double purchaseprice, String symbol, int amount, int portid);

}
