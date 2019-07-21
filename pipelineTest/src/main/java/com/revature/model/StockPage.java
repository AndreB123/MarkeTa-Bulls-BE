package com.revature.model;


/*
 * StockPage class using Java Bean design pattern. Tables are mapped with annotations
 * within the class. This is the join table class. 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockpage", schema="\"StockProj\"")
public class StockPage {

	@Id
	@Column(name="stockportfolioid")
	private int portfolioid;
	@Id
	@Column(name="stockpageid")
	private int stockid;
	public StockPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockPage(int portfolioid, int stockid) {
		super();
		this.portfolioid = portfolioid;
		this.stockid = stockid;
	}
	public int getPortfolioid() {
		return portfolioid;
	}
	public void setPortfolioid(int portfolioid) {
		this.portfolioid = portfolioid;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + portfolioid;
		result = prime * result + stockid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockPage other = (StockPage) obj;
		if (portfolioid != other.portfolioid)
			return false;
		if (stockid != other.stockid)
			return false;
		return true;
	}
	
}
