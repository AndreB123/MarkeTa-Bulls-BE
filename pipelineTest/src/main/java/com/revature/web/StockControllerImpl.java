package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Stock;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.StockService;

@RestController
@RequestMapping(path = "/MarkeTa-Bulls")
public class StockControllerImpl implements StockController {

	private StockService ss;

	@Autowired
	public void setSs(StockService ss) {
		this.ss = ss;
	}

	@Override
	@RequestMapping(value = "/stockpage", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com/")
	public List<Stock> getAllStocks(@RequestParam(name = "portId") int id) {
		System.out.println("stock controller method");
		ss.getAllStocks(id);
		return null;
	}

	@Override
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com/")
	public String getStockById(@RequestParam(name = "stockId") int id) {
		System.out.println("stock controller method");
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(ss.getStockById(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Stock Request Failed";
	}

	@Override
	@RequestMapping(value = "/updateStock", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com/")
	public void updateStock(@RequestParam(name="sellAmount")String amount, @RequestParam(name="stockId")String stockId, @RequestParam(name="username")String user, @RequestParam(name="overallBalance") String balance) {
		System.out.println(amount);
		System.out.println(stockId);
		System.out.println(user);
		System.out.println(balance);
		if(Integer.parseInt(amount) >= 0) {
			double profit = Integer.parseInt(amount) * Double.parseDouble(balance);
			new UserRepositoryImpl().updateBalance(user, profit);
			ss.updateStock(Integer.parseInt(amount), Integer.parseInt(stockId));
		}
		return;
	}

	@Override
	@RequestMapping(value="/insertStock", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com/")
	public Stock insertStock(@RequestParam(name="purchaseprice")String price,@RequestParam(name="symbol")String symbol,@RequestParam(name="amount")String amount, @RequestParam(name="portId")String id) {
		ss.insertStock(Double.parseDouble(price), symbol, Integer.parseInt(amount), Integer.parseInt(id));
		return null;
	}

	@Override
	@RequestMapping(value = "/removeStock", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://market-ta-bulls.s3-website-us-west-1.amazonaws.com/")
	public Stock removeStock(@RequestParam(name = "portId") int id) {
		ss.removeStock(id);
		return null;
	}

}
