package com.revature.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;



@Repository("pr")
public interface PortfolioRepository {

	List<Portfolio> getAllPortfolios();	
	Portfolio getPortfolioById(int id);
	void insertPortfolio(Portfolio p);
	void deletePortfolio(Portfolio p);

}
