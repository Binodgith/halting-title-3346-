package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.Exception.CustomerException;
import com.Exception.TransactionException;
import com.Model.Transaction;
import com.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	 public boolean CustomerLogin(String email,int password) throws CustomerException{
		 
		 boolean flag = false;
			try (Connection conn = DBUtil.provideConnection()) {

				PreparedStatement ps = conn.prepareStatement("select * from Customer where email=? and Password=?");
				ps.setString(1, email);
				ps.setInt(2, password);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					flag = true;
				}

			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());

			}

			return flag;
		 
	 }
	

	@Override
	public String FindName(String email, int password) throws CustomerException {
		// TODO Auto-generated method stub
		String response = null;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where email=? and Password=?");
			ps.setString(1, email);
			ps.setInt(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				response = rs.getString("name");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return response;
	}

	@Override
	public int TranforMoney(String senderUsername, String ReceiverUsername, int Balance) throws CustomerException {
		// TODO Auto-generated method stub

		int i = 0;
		java.util.Date date =  Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into Transaction (sender,Receiver,Balance,date)  values(?,?,?,?)");

			ps.setString(1, senderUsername);
			ps.setString(2, ReceiverUsername);
			ps.setInt(3, Balance);
			ps.setString(4, strDate);
			int x = ps.executeUpdate();

			if (x > 0) {

				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return i;
	}

	@Override
	public String ReciverUsername(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub

		String message = null;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where AccountNo=?");
			ps.setInt(1, AccountNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = rs.getString("email");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return message;
	}

	@Override
	public int BalanceCheck(String email) throws CustomerException {
		// TODO Auto-generated method stub
		
		int i = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = rs.getInt("Balance");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public int SubSenderMoney(int balance, String email) throws CustomerException {
		// TODO Auto-generated method stub

		int i = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("update Customer set balance=balance-? where email=? and balance-?>=0 ");
			ps.setInt(1, balance);
			ps.setString(2, email);
			ps.setInt(3, balance);              //problem
			int rs = ps.executeUpdate();
			if (rs>0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public int AddReciverAmount(int Balance, String email) throws CustomerException {
		// TODO Auto-generated method stub

		int i = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Customer set balance = balance+? where email=? ");
			ps.setInt(1, Balance);
			ps.setString(2, email);
			int rs = ps.executeUpdate();
			if (rs>0) {
				i++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return i;
	}

	@Override
	public List<Transaction> CheckTransactionHistory(String email) throws TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> transaction = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from transaction where sender=? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int tid = rs.getInt("Transaction_Id");
				String Sender = rs.getString("Sender");
				String Receiver = rs.getString("Receiver");
				int Balance = rs.getInt("Balance");
				String date = rs.getString("date");
				Transaction trans = new Transaction(tid, Sender, Receiver, Balance, date);
				transaction.add(trans);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return transaction;
	}

	
}
