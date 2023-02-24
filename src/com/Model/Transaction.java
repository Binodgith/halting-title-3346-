package com.Model;


public class Transaction {
	
	private int Transaction_Id;
	private String  SenderName;
	private String RecieverName;
	private int Balance;
	private String date;
	
	public Transaction() {}

	public Transaction(int transaction_Id, String senderName, String recieverName, int balance, String date) {
		super();
		Transaction_Id = transaction_Id;
		SenderName = senderName;
		RecieverName = recieverName;
		Balance = balance;
		this.date = date;
	}

	public int getTransaction_Id() {
		return Transaction_Id;
	}

	public void setTransaction_Id(int transaction_Id) {
		Transaction_Id = transaction_Id;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getRecieverName() {
		return RecieverName;
	}

	public void setRecieverName(String recieverName) {
		RecieverName = recieverName;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [Transaction_Id=" + Transaction_Id + ", SenderName=" + SenderName + ", RecieverName="
				+ RecieverName + ", Balance=" + Balance + ", date=" + date + "]";
	}

	

	
}
