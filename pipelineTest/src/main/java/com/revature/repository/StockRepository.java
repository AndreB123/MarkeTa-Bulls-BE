package com.revature.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.revature.model.Stock;

@Repository("sr")
public interface StockRepository {
	List<Stock> getAllStocks();
	public Stock getStockById(int id);

}
