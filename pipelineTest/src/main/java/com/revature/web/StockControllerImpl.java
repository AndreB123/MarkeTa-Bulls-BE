package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Stock;
import com.revature.service.StockService;

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
		return ss.getAllStocks(req, resp);
	}

}
