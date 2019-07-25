package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Portfolio;

public interface PortfolioController {
	//public List<Portfolio> getAllPortfolios(HttpServletRequest req, HttpServletResponse resp);
	public Portfolio getPortfolioById(HttpServletRequest req, HttpServletResponse resp);	
	public Portfolio insertPortfolio(String username, String portname);
	String getAllPortfolios(String username);
}
