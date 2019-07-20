package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Stock;
import com.revature.repository.StockRepository;
import com.revature.repository.StockRepositoryImpl;

@Service("ss")
public class StockServiceImpl implements StockService {

	private StockRepositoryImpl sr2;

	@Autowired
	public StockServiceImpl(StockRepository sr) {
		this.sr2 = sr2;
	}

	@Override
	public List<Stock> getAllStocks(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		int portfolioId = Integer.parseInt((String)s.getAttribute("portfolioid"));
		return new StockRepositoryImpl().getAllStocks(portfolioId);
	}

}
