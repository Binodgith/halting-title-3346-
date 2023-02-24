package com.Usecase;

import java.util.List;
import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.CustomerException;
import com.Exception.TransactionException;
import com.Model.Transaction;
import com.Style.consolecolor;

public class MainCustomer {
	private String username;
	private int password;
	private String name;

	public String getUsername() {
		return username;
	}

	public int getPassword() {
		return password;
	}

	CustomerDao s = new CustomerDaoImpl();

	public boolean LoginCheckCustomer() throws CustomerException {
		boolean con1 = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Username" + consolecolor.RESET);
			String Username = sc.next();
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int Password = sc.nextInt();
			boolean p = s.CustomerLogin(Username, Password);
			if (p == true) {
				this.username = Username;
				this.password = Password;
				this.name = s.FindName(Username, Password);
				System.out.println(consolecolor.PURPLE_BOLD + "Login Sucessfully" + consolecolor.RESET);
				con1 = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "Wrong your email or Password" + consolecolor.RESET);
			}
		}

		return con1;
	}

	public int CustomerWorkType() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				consolecolor.GREEN + "+-----------------------------------------------------------+\r\n"
						+ "|                     ENTER YOUR NUMBER                     |\r\n"
						+ "+-----------------------------------------------------------+\r\n"
						+ "|                                               	    | \r\n"
						+ "| 1.Transfer the money from his account to other account    |\r\n"
						+ "| 2.Checking the transaction history                        |\r\n"
						+ "| 3. Exit  				   	            |\r\n"
						+ "+-----------------------------------------------------------+" + consolecolor.RESET);
		System.out.println(consolecolor.BROWN+"Enter your Number accoding Your Work" + consolecolor.RESET);
		int accWork = sc.nextInt();
		return accWork;
	}

	public void SenderToMoney() throws CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW_BOLD +"Enter AccountNo"+consolecolor.RESET);
		int id = sc.nextInt();
		String reciverUsername = s.ReciverUsername(id);
		if (reciverUsername == null) {
			System.out.println(consolecolor.RED+"Enter Correcet AccountNo or this person may have any account"+consolecolor.RESET);
			return;
		}
		System.out.println(consolecolor.YELLOW_BOLD +"Enter Amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		int AmountCheck = s.BalanceCheck(this.username);
		if (AmountCheck < Amount) {
			System.out.println(consolecolor.BROWN+"************/ Insufficient Balance /*************"+consolecolor.RESET);
			return;
		}
		int i = s.TranforMoney(this.username, reciverUsername, Amount);
		if (i == 1) {
			System.out
					.println(consolecolor.PURPLE_BOLD+"/***************/ Transfer Money Successfully /*******************/"+consolecolor.RESET);
			int st = s.SubSenderMoney(Amount, this.username);
			int rt = s.AddReciverAmount(Amount, reciverUsername);
			if (st == 1 && rt == 1) {
				System.out.println(consolecolor.LIGHT_GREEN+"Process completed......................"+consolecolor.RESET);
			}

		} else {
			System.out.println(consolecolor.BROWN+"No Send Money"+consolecolor.RESET);
		}

	}
	public void transactionhistory () throws TransactionException {
	List<Transaction> list=s.CheckTransactionHistory(this.username);
	list.forEach(s->System.out.println(consolecolor.PURPLE_BOLD+s+consolecolor.RESET));
	}

}
