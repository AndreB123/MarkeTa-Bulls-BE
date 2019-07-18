package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;

@Repository("pr")
public class PortfolioRepositoryImpl implements PortfolioRepository {

	@Override
	public List<Portfolio> getAllPortfolios() {

		return null;

	}

}
