package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		System.out.println("controller login method");
		us.isValidUser(req, resp);
		
		return;
	}

	@Override
	@RequestMapping(value="/CreateUser", method=RequestMethod.POST)
	public void createUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("controller login method");
		us.newUser(req, resp);
		return;
	}

	
	
}
