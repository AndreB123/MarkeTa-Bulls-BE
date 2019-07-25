package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Stock;
import com.revature.service.StockService;

@RestController
@RequestMapping(path="/MarkeTa-Bulls")
public class StockControllerImpl implements StockController {

	private StockService ss;

	@Autowired
	public void setSs(StockService ss) {
		this.ss = ss;
	}

	@Override
	@RequestMapping(value = "/stockpage", method = RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	public List<Stock> getAllStocks(@RequestParam(name="portId")int id) {
		System.out.println("stock controller method");
		ss.getAllStocks(id);
		return null;
	}

	@Override
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200")
	public String getStockById(@RequestParam(name="stockId") int id) {
		System.out.println("stock controller method");
		ObjectMapper mapper= new ObjectMapper(); 
		try {
			return mapper.writeValueAsString(ss.getStockById(id));
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Stock Request Failed";
	}

	@Override
	@RequestMapping(value="/updateStock", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Stock updateStock(@RequestParam(name="amount")int amount) {
		ss.updateStock(amount);
		return null;
	}

	@Override
	@RequestMapping(value="/insertStock", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public Stock insertStock(@RequestParam(name="portId")int id, @RequestParam(name="symbol") String symbol, @RequestParam(name="amount") int amount, @RequestParam(name="price") double price) {
		ss.insertStock(id,symbol,amount,price);
		return null;
	}

	@Override
	@RequestMapping(value="/removeStock", method =RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public Stock removeStock(@RequestParam(name="portId") int id) {
		ss.removeStock(id);
		return null;
	}


}

