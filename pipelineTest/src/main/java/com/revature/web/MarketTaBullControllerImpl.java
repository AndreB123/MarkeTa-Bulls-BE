package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void isValidUser(HttpServletRequest req, HttpServletResponse resp) {
		us.isValidUser(req, resp);
		
		return;
	}

}
