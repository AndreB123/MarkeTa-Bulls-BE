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
		int portfolioId = (int)s.getAttribute("portfolioid");
		System.out.println("service " + portfolioId);
		return sr2.getAllStocks(portfolioId);
	}

	@Override
	public Stock getStockById(HttpServletRequest req, HttpServletResponse resp) {
		return sr2.getStockById(1);
	}

}
