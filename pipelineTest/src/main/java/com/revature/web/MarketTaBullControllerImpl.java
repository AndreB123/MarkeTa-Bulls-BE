package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.UserService;

@RestController
@RequestMapping(path="/MarkeTa-Bulls")
public class MarketTaBullControllerImpl implements MarketTaBullController{

	private UserService us;
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	@Override
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void isValidUser(HttpServletRequest req, HttpServletResponse resp) {
		us.isValidUser(req, resp);
		
		return;
	}

}
