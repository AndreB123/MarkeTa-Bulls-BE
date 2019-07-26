package com.revature.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Portfolio;
import com.revature.model.Stock;
import com.revature.repository.StockRepositoryImpl;
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
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com")
	public String getAllPortfolios(@RequestParam(name = "Username") String username) {
		System.out.println(username);
		ObjectMapper mapper = new ObjectMapper();
		String Re = "{\"portfolios\": [";
		try {
			List<Portfolio> li = ps.getAllPortfolios(username);
			List<List<Stock>> st = new ArrayList <List <Stock>>();
			for(int i = 0; i < li.size(); i++) {
				Re += mapper.writeValueAsString(li.get(i));
				if(null != new StockRepositoryImpl().getAllStocks(li.get(i).getId()))
					st.add(new StockRepositoryImpl().getAllStocks(li.get(i).getId()));
				if(i != li.size()-1)
					Re +=",";
			}
			Re += "], \"stocks\": [";
			for(int i = 0; i < st.size(); i++)
			{
				Re += "{ \"port-" + i + "\": [";
				for(int j = 0; j < st.get(i).size(); j++) {
					Re += mapper.writeValueAsString(st.get(i).get(j));
					if(j != st.get(i).size()-1)
						Re +=",";
				}
				Re +="]}";
				if(i != st.size()-1)
					Re +=",";
			}
			Re += "]}";
			System.out.println(Re);
			return Re;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Portfolio Request Failed";

	}

	@Override
	@RequestMapping(value = "/APortfolio", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com")
	public Portfolio getPortfolioById(@RequestParam(name ="portId") int id) {		
		ps.getPortfolioById(id);
		return null;
		
	}
    @Override
	@RequestMapping(value = "/insertPortfolio", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com")
	public Portfolio insertPortfolio(@RequestParam(name = "Username") String username, @RequestParam(name = "name") String portname) {
		System.out.println(portname);
		System.out.println(username);
		ps.insertPortfolio(username, portname);
		return null;
	}

	@Override
	@RequestMapping(value = "/sellPortfolio", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com")
	public void SellPortfolio(@RequestParam(name = "portId")int id) {
		System.out.println(id);
		ps.SellPortfolio(id);
		return;
	}
	
}
