package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Stock class using Java Bean design pattern. Tables are mapped with annotations
 * within the class. 
 */

@Entity
@Table(name="stocktable", schema="\"StockProj\"")
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_stockid_seq")
	@SequenceGenerator(name="stock_stockid_seq", sequenceName="\"StockProj\".stock_stockid_seq", allocationSize=1)
	@Column(name="stockid")
	private int id;
	@Column(name="purchaseprice")
	private double purchaseprice;
	@Column(name="stocksym")
	private String symbol;
	@Column(name="amount")
	private int amount;
	@Column(name="portId")
	private int portid;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(int id, double purchaseprice, String symbol, int amount, int portid) {
		super();
		this.id = id;
		this.purchaseprice = purchaseprice;
		this.symbol = symbol;
		this.amount = amount;
		this.portid = portid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + id;
		result = prime * result + portid;
		long temp;
		temp = Double.doubleToLongBits(purchaseprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Stock other = (Stock) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (portid != other.portid)
			return false;
		if (Double.doubleToLongBits(purchaseprice) != Double.doubleToLongBits(other.purchaseprice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", purchaseprice=" + purchaseprice + ", symbol=" + symbol + ", amount=" + amount
				+ ", portid=" + portid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPortid() {
		return portid;
	}

	public void setPortid(int portid) {
		this.portid = portid;
	}

}
	