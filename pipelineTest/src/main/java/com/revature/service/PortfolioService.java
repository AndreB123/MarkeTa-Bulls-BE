package com.revature.service;

import java.util.List;

import com.revature.model.Portfolio;

public interface PortfolioService {
	List<Portfolio> getAllPortfolios(String username);
	Portfolio getPortfolioById(int id);
	void insertPortfolio(String username, String portname);
	void SellPortfolio(int id);
}
