package com.revature.web;



public interface MarketTaBullController {

	public String isValidUser(String username, String Password);	
	public void getAllUsers(String username, String password);
	public void createUser(String username, String password, String balance);

}
