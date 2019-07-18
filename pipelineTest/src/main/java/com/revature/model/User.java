package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users", schema="StockProj")
public class User {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="userpassword")
	private String password;
	@Column(name="balance")
	private Double balance;
	@OneToMany(mappedBy = "username")
	private List<Portfolio> portfolios;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, Double balance, List<Portfolio> portfolios) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.portfolios = portfolios;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public List<Portfolio> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((portfolios == null) ? 0 : portfolios.hashCode());
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
		User other = (User) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (portfolios == null) {
			if (other.portfolios != null)
				return false;
		} else if (!portfolios.equals(other.portfolios))
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
		return "User [username=" + username + ", password=" + password + ", balance=" + balance + ", portfolios="
				+ portfolios + "]";
	}

}
