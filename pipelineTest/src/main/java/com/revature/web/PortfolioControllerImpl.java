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
	@RequestMapping(value="/Portfolios", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public String getAllPortfolios(@RequestParam(name="Username") String username) {
		System.out.println(username);
		String Re = "{ \"portfolios\": [";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Portfolio> li = ps.getAllPortfolios(username);
			for(int i = 0; i < li.size(); i++) {
				Re += mapper.writeValueAsString(li.get(i));
				if(i != li.size()-1)
					Re += ",";
			}
			Re += "]}";
			System.out.println(Re);
			return Re;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/APortfolio", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Portfolio getPortfolioById(@RequestParam(name ="portId") int id) {		
		ps.getPortfolioById(id);
		return null;
		
	}
    @Override
	@RequestMapping(value = "/insertPortfolio", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
	public Portfolio insertPortfolio(@RequestParam(name="portId") int id) {
		ps.insertPortfolio(id);	
		return null;
	}
	
}
