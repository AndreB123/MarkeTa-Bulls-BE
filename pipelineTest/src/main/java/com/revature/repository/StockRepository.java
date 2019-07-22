package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Stock;

/*
 * 
 */
@Repository("sr")
public interface StockRepository {

	public Stock getStockById(int id);

	List<Stock> getAllStocks(int id);

}
