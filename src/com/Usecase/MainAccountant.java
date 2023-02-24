package com.Usecase;

import java.util.List;
import java.util.Scanner;

import com.Style.consolecolor;
import com.Dao.AccountantDao;
import com.Dao.AccountantDaoImpl;
import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransactionException;
import com.Model.Customer;
import com.Model.Transaction;

public class MainAccountant {

	AccountantDao dao = new AccountantDaoImpl();
	public int firstPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.CYAN_BOLD + "+---------------------------+" + "\n"
				   + "| 1. Login As Accountant    |" + "\n"
				   + "| 2. Login As Customer      |" + "\n"
				   + "| 3. Exit                   |" + "\n"
				   + "+---------------------------+" + consolecolor.RESET);
	
		System.out.println("Put Your Number Based On Your Work"+consolecolor.RESET);
		int n = sc.nextInt();
		return n;

	}

	public boolean Logincheck() throws AccountantException {
		boolean con1 = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your email" + consolecolor.RESET);
			String HODEMAIL = sc.next();
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int HODPASSWORD = sc.nextInt();
			boolean p = dao.AccountantLogin(HODEMAIL, HODPASSWORD);
			
			if (p == true) {
				System.out.println(consolecolor.PURPLE_BOLD+ "Login Sucessfully" + consolecolor.RESET);
				con1 = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "Wrong your Username or password" + consolecolor.RESET);
			}
		}

		return con1;
	}

	public int AccoutentWorkType() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(consolecolor.GREEN_BOLD+"+-----------------------------------------------------------+\r\n"
				+ "|  ENTER YOUR NUMBER                             	|\r\n"
				+ "+------------------------------------------------------+|\r\n"
				+ "|                                               	| \r\n"
				+ "| 1.Add new account                      		|\r\n"
				+ "| 2.UpdateExistingCustomer account                      |\r\n"
				+ "| 3.Remove the account by using account number          |\r\n"
				+ "| 4.Viewing particular account details account number   |\r\n"
				+ "| 5.Viewing all the account details          		|\r\n"
				+ "| 6.Taking care of deposit and withdrawal operations 	|\r\n"
				+ "| 7.Exit                                                |\r\n"
				+ "+-----------------------------------------------------------+" + consolecolor.RESET);
		System.out.println("Enter your Number accoding Your Work");
		int accWork = sc.nextInt();
		return accWork;
	}

	public void addCustomer() throws  CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"enter Customer name"+consolecolor.RESET);
		String name = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer username"+consolecolor.RESET);
		String username = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer Password"+consolecolor.RESET);
		int Password = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		
		int p = dao.AddCustomer(name, username, Password, AccountNo, Amount);
		if (p == 1) {
			System.out.println(
					consolecolor.PURPLE_BOLD+ "Data Inserted.." + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"Wrong Information"+consolecolor.RESET);
		}
	}
// scanner problem
	public void UpdateExistingCustomer() throws  CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"enter Customer name"+consolecolor.RESET);
		String name = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer email"+consolecolor.RESET);
		String email = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"enter Customer Password"+consolecolor.RESET);
		int Password = sc.nextInt();
		
		System.out.println(consolecolor.YELLOW+"enter Customer amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"enter Customer id"+consolecolor.RESET);
		int Customerid = sc.nextInt();
		sc.nextLine();
		int p = dao.UpdateExistingCustomer(name, email, Password,Amount,AccountNo,Customerid);
		if (p == 1) {
			System.out.println(
					consolecolor.PURPLE_BOLD + "Update Successfully" + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"Wrong Information"+consolecolor.RESET);
		}
		
	}
	public void RemoveCustomerAccNo() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=dao.RemoveCustomer(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.GREEN+"*************Delete your "+AccountNo+" detail**************"+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.RED+"************Enter Correct Account No*************"+consolecolor.RESET);
		}
	}
	public void VeiwParticularDetal() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=dao.VeiwParticularAccount(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.GREEN_BACKGROUND+consolecolor.PURPLE_BOLD+"**********Print customer  "+AccountNo+" detail**************"+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.ROSY_PINK+"Enter Correct Account No"+consolecolor.RESET);
		}
	}
	public void AllCustomerDetail() throws CustomerException {
		List<Customer> detail=dao.AllCustomerDetail();
		detail.forEach(s->System.out.println(consolecolor.BLUE+s+consolecolor.RESET));
		System.out.println(consolecolor.LIGHT_PINK+"**************"+consolecolor.RESET);
	}
	public void AllTransaction() throws TransactionException {
		List<Transaction> tDetail=dao.TransactionList();
		tDetail.forEach(s->System.out.println(consolecolor.BLUE+s+consolecolor.RESET));
	}
}
