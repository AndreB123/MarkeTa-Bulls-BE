package com.revature.web;

import com.revature.model.Portfolio;


/*
 * All the methods that will be used within the PortfolioControllerImpl.
 */
public interface PortfolioController {
	//public List<Portfolio> getAllPortfolios(HttpServletRequest req, HttpServletResponse resp);
	public Portfolio getPortfolioById(int id);	
	public Portfolio insertPortfolio(String username, String portname);
	String getAllPortfolios(String username);

}
