package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Stock;

public interface StockService {

	//List<Stock> getAllStocks(int portfolioId);

	List<Stock> getAllStocks(HttpServletRequest req, HttpServletResponse resp);

}
