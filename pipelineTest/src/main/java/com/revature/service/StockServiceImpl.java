package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Stock;
import com.revature.repository.StockRepository;

@Service("ss")
public class StockServiceImpl implements StockService {

	private StockRepository sr2;

	@Autowired
	public StockServiceImpl(StockRepository sr) {
		this.sr2 = sr;
	}

	public void setSr(StockRepository sr) {
		this.sr2 = sr2;
	}

	@Override
	public List<Stock> getAllStocks(int id) {
		return sr2.getAllStocks(id);
	}

	@Override
	public Stock getStockById(int id) {
		return sr2.getStockById(id);
	}

	@Override
	public void updateStock(int amount, int id) {
		sr2.updateStock(amount, id);
		return;
	}

	@Override
	public Stock insertStock(int id, String symbol, int amount, double price) {
		return sr2.insertStock(id, symbol, amount, price);
	}

	@Override
	public void removeStock(int id) {
		sr2.removeStock(id);
		return;
	}

}
