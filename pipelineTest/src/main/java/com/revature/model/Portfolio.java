package com.revature.model;

/*
 * Portfolio class using Java Bean design pattern. Tables are mapped with annotations
 * within the class. 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="portfolio", schema="\"StockProj\"")
public class Portfolio {
	@Id
	@Column(name="portfolioId")
	private int id;
	@Column(name="portName")
	private String name;
	@Column(name="stockprice")
	private double initBalance;
	@Column(name="portusername")
	private String username;
	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Portfolio(int id, String name, double initBalance, String username) {
		super();
		this.id = id;
		this.name = name;
		this.initBalance = initBalance;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInitBalance() {
		return initBalance;
	}
	public void setInitBalance(double initBalance) {
		this.initBalance = initBalance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(initBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Portfolio other = (Portfolio) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(initBalance) != Double.doubleToLongBits(other.initBalance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", name=" + name + ", initBalance=" + initBalance + ", username=" + username
				+ "]";
	}
	
}
