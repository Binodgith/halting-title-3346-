package com.Model;



public class Customer {

	private int Customer_Id;
	private String name;
	private String email;
	private int password;
	private int AccountNo;
	private int Balance;
	
	public Customer() {}

	public Customer(int customer_Id, String name, String email, int password, int accountNo, int balance) {
		super();
		Customer_Id = customer_Id;
		this.name = name;
		this.email = email;
		this.password = password;
		AccountNo = accountNo;
		Balance = balance;
	}

	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [Customer_Id=" + Customer_Id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", AccountNo=" + AccountNo + ", Balance=" + Balance + "]";
	};
	
	

	
	
}

