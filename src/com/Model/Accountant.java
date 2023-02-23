package com.Model;


public class Accountant {

	private int Acc_Id;
	private String name;
	private String email;
	private String password;
	
	public  Accountant() {}

	public Accountant(int acc_Id, String name, String email, String password) {
		super();
		Acc_Id = acc_Id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getAcc_Id() {
		return Acc_Id;
	}

	public void setAcc_Id(int acc_Id) {
		Acc_Id = acc_Id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Accountant [Acc_Id=" + Acc_Id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	};
	
	
}

