package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Portfolio;
import com.revature.repository.PortfolioRepository;
import com.revature.repository.PortfolioRepositoryImpl;

@Service("ps")
public class PortfolioServiceImpl implements PortfolioService {

	private PortfolioRepository pr2;

	@Autowired
	public PortfolioServiceImpl(PortfolioRepositoryImpl pr) {
		this.pr2 = pr;
	}

	public void setPr(PortfolioRepository pr) {
		this.pr2 = pr2;
	}

	@Override
	public List<Portfolio> getAllPortfolios(String username) {
		return pr2.getAllPortfolios(username);
	}

	@Override
	public Portfolio getPortfolioById(int id) {
		return pr2.getPortfolioById(id);
	}

	@Override
	public void insertPortfolio(String username, String portname) {
		pr2.insertPortfolio(username, portname);
		return;
	}

	@Override
	public void SellPortfolio(int id) {
		pr2.sellPortfolio(id);
		return;
	}
}
