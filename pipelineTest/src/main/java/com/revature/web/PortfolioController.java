package com.revature.web;

import com.revature.model.Portfolio;

public interface PortfolioController {

	//public List<Portfolio> getAllPortfolios(HttpServletRequest req, HttpServletResponse resp);
	public Portfolio getPortfolioById(int id);	
	public Portfolio insertPortfolio(String username, String portname);
	String getAllPortfolios(String username);
	public void SellPortfolio(int id);


}
