package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Portfolio;

public interface PortfolioController {
	public String getAllPortfolios(String username);
	public Portfolio getPortfolioById(HttpServletRequest req, HttpServletResponse resp);
}
