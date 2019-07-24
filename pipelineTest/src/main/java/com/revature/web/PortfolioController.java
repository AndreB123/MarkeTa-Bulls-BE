package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Portfolio;

public interface PortfolioController {
	//public List<Portfolio> getAllPortfolios(HttpServletRequest req, HttpServletResponse resp);
	public Portfolio getPortfolioById(HttpServletRequest req, HttpServletResponse resp);	
	public Portfolio insertPortfolio(HttpServletRequest req, HttpServletResponse resp);
	String getAllPortfolios(String username);
}
