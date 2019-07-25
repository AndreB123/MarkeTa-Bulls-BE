package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockController {
	public List<Stock> getAllStocks(int id);
<<<<<<< HEAD

	public Stock updateStock(int amount);

=======
>>>>>>> f507904b65260574f9ed2f6537e34a4606a9a9c9
	public Stock insertStock(int id, String symbol, int amount, double price);
	String getStockById(int id);
	public Stock updateStock(int amount);
	public Stock removeStock(int id);

}
