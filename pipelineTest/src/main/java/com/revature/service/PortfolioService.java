package com.revature.service;

import java.util.List;

import com.revature.model.Portfolio;

public interface PortfolioService {
	List<Portfolio> getAllPortfolios(String username);
}
