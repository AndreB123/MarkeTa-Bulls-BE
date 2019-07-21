package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocktable", schema="\"StockProj\"")
public class Stock {

	@Id
	@Column(name="stockid")
	private int id;
	@Column(name="purchaseprice")
	private double purchaseprice;
	@Column(name="stocksym")
	private String symbol;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int id, double purchaseprice, String symbol) {
		super();
		this.id = id;
		this.purchaseprice = purchaseprice;
		this.symbol = symbol;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
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
		return "Stock [id=" + id + ", purchaseprice=" + purchaseprice + ", symbol=" + symbol + "]";
	}
	
}
