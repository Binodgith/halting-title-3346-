package com.Main;

import java.util.Scanner;

import com.Exception.AccountantException;
import com.Exception.CustomerException;
import com.Exception.TransactionException;
import com.Usecase.MainAccountant;
import com.Usecase.MainCustomer;

public class Main {

	public static void main(String[] args) throws AccountantException, CustomerException, TransactionException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		MainAccountant dao = new MainAccountant();
		MainCustomer cdao = new MainCustomer();
		while (true) {
			int n = dao.firstPrint();
			if (n == 1) {
				boolean ch = dao.Logincheck();
				if (ch == true) {
					while (true) {
						int an = dao.AccoutentWorkType();
						if (an == 1) {
							dao.addCustomer();
						} else if (an == 2) {
							dao.UpdateExistingCustomer();
						} else if (an == 3) {
							dao.RemoveCustomerAccNo();
						} else if (an == 4) {
							dao.VeiwParticularDetal();
						} else if (an == 5) {
							dao.AllCustomerDetail();
						} else if (an == 6) {
							dao.AllTransaction();
						} else {
							break;
						}

					}
				}
			} else if (n == 2) {
				boolean bh = cdao.LoginCheckCustomer();
				if (bh == true) {
					while (true) {
						int cw = cdao.CustomerWorkType();
						if (cw == 1) {
							cdao.SenderToMoney();
						} else if (cw == 2) {
							cdao.transactionhistory();
						} else {
							break;
						}
					}
				}
			} else if (n == 3) {
				break;
			}
		}

	}

	}

