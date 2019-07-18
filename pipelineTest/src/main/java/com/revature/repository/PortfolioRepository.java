package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;

@Repository("pr")
public interface PortfolioRepository {

	List<Portfolio> getAllPortfolios();

}
