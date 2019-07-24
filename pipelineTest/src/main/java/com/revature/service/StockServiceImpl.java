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
	public List<Stock> getAllStocks(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int stockId = (int)s.getAttribute("stockId");
		System.out.println("service " + stockId);
		sr2.getAllStocks(stockId);
		return null;
	}

	@Override
	public Stock getStockById(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int stockId = (int)s.getAttribute("stockId");
		return sr2.getStockById(1);
	}

	@Override
	public Stock updateStock(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int stockId = (int)s.getAttribute("stockId");
		int amount = (int)s.getAttribute("amount");
		return sr2.updateStock(stockId, amount);
	}

	@Override
	public Stock insertStock(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int stockId = (int)s.getAttribute("stockId");
		int amount = (int)s.getAttribute("amount");
		return sr2.insertStock(stockId, amount);
	}

	@Override
	public Stock removeStock(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int stockId = (int)s.getAttribute("stockId");		
		return sr2.removeStock(stockId);
	}

	

}

