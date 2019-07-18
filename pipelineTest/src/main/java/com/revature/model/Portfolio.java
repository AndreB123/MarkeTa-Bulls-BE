package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="portfolio", schema="StockProj")
public class Portfolio {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="initBalance")
	private int initBalance;
	@Column(name="username")
	private String username;
	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Portfolio(int id, int initBalance, String username) {
		super();
		this.id = id;
		this.initBalance = initBalance;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInitBalance() {
		return initBalance;
	}
	public void setInitBalance(int initBalance) {
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
		result = prime * result + initBalance;
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
		if (initBalance != other.initBalance)
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
		return "Portfolio [id=" + id + ", initBalance=" + initBalance + ", username=" + username + "]";
	}
	
	
}
