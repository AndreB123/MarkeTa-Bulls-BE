package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Portfolio;
import com.revature.service.PortfolioService;

@RestController
@RequestMapping(path = "/MarkeTa-Bulls")
public class PortfolioControllerImpl implements PortfolioController {

	private PortfolioService ps;

	@Autowired
	public void setPs(PortfolioService ps) {
		this.ps = ps;
	}

	@Override
	@RequestMapping(value = "/Portfolios", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public String getAllPortfolios(@RequestParam(name = "portfolioId") String username) {
		System.out.println(username);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(ps.getAllPortfolios(username));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Portfolio Request Failed";

	}

	@Override
	@RequestMapping(value = "/APortfolio", method = RequestMethod.GET)
	public Portfolio getPortfolioById(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		s.setAttribute("portfolioId", 1);
		return null;
	}

	@RequestMapping(value = "/insertPortfolio", method = RequestMethod.POST)
	public Portfolio insertPortfolio(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		s.setAttribute("portfolioId", 1);
		return null;
	}

}
