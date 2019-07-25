package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Portfolio;

public interface PortfolioController {
	String getAllPortfolios(String username);
	public Portfolio getPortfolioById(int id);
	public Portfolio insertPortfolio(int id);
}
