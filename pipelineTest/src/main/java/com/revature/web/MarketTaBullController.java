package com.revature.web;

/*
 * All the methods that will be used within the MarkeTaBullControllerImpl.
 */

public interface MarketTaBullController {
	public String isValidUser(String username, String Password);	
	public void getAllUsers(String username, String password);
	public void createUser(String username, String password, double balance);

}
