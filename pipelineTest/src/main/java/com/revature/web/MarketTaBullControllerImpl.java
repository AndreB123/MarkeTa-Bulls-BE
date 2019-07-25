package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	@CrossOrigin(origins = "http://localhost:4200")
	public String isValidUser(@RequestParam(name="Username") String Username, @RequestParam(name="password") String password) {
		System.out.println("controller login method");
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(us.isValidUser(Username, password));
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return "Failed";
	}

	@Override
	@RequestMapping(value="/CreateUser", method=RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void createUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("controller Create User method");
		us.newUser(req, resp);

		return;
	}

}
