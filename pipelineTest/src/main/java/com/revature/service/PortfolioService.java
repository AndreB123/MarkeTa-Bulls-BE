package com.revature.service;

import java.util.List;

import com.revature.model.Portfolio;

/*
 * The PortfolioService listing the methods that will be implemented in the 
 * PortfolioServiceImpl. 
 */
public interface PortfolioService {
	List<Portfolio> getAllPortfolios(String username);
	Portfolio getPortfolioById(int id);
	void insertPortfolio(String username, String portname);
}
