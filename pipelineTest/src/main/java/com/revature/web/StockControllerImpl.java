package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Stock> getAllStocks(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("stock controller method");
		ss.getAllStocks(req, resp);
		return null;
	}

	@Override
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public Stock getStockById(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("stock controller method");
		ss.getStockById(req, resp);
		return null;
	}

}

