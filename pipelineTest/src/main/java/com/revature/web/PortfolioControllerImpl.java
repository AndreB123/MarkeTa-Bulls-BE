package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Portfolio;
import com.revature.service.PortfolioService;

@RestController
@RequestMapping(path="/MarkeTa-Bulls")
public class PortfolioControllerImpl implements PortfolioController{

	private PortfolioService ps;
	
	@Autowired
	public void setPs(PortfolioService ps) {
		this.ps = ps;
	}
	
	@Override
	@RequestMapping(value="/Portfolios", method=RequestMethod.GET)
	public List<Portfolio> getAllPortfolios(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		String username = (String)s.getAttribute("user's name");
		System.out.println(username);
		ps.getAllPortfolios(username);
		return null;
	}

	@Override
	@RequestMapping(value="/APortfolio", method=RequestMethod.GET)
	public Portfolio getPortfolioById(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
