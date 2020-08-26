package in.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.bank.entity.AccountInfo;
import in.bank.entity.Transaction;
import in.bank.entity.TransactionInfo;
import in.bank.util.DBConnectionUtil;

public class TransactionDAOImplement implements TransactionDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public AccountInfo getAccount(String firstName, String lastName, String accountNumber) {
		AccountInfo account = null;
		String sql = "SELECT * from accountInfo WHERE first_Name = '"+firstName+"' AND last_Name = '"+lastName+"' AND account_Number = '"+accountNumber+"'";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			while(resultSet.next()) {
				account = new AccountInfo();
				account.setFirstName(resultSet.getString("first_Name"));
				account.setLastName(resultSet.getString("last_Name"));
				account.setAccountNumber(resultSet.getString("account_Number"));
				account.setAccountType(resultSet.getString("type_Name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return account;
	}

	@Override
	public double getBalance(String accountNumber) {
		double balance  = 0;
		String sql = "SELECT sum(amount) " + 
				"FROM customer " + 
				"INNER JOIN account ON account.customer_ID = customer.customer_ID " + 
				"INNER JOIN transactions ON transactions.account_ID = account.account_ID " + 
				"WHERE account.account_Number = '"+accountNumber+"'";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			balance = resultSet.getInt(1);
//			System.out.println("SQL: "+sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public List<TransactionInfo> getTransactionList(String accountNumber) {
		String sql = "SELECT * " + 
				"FROM transactionView " + 
				"WHERE transactionView.account_Number = '"+accountNumber+"'";
		// Create reference variables
		List<TransactionInfo> list = null;
		TransactionInfo transactionList = null;	
		try {
			list = new ArrayList<TransactionInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			// Process the resultSet
			while(resultSet.next()) {
				transactionList = new TransactionInfo();
				transactionList.setTransaction_ID(resultSet.getInt("transaction_ID"));
				transactionList.setAccount_Number(resultSet.getString("account_Number"));				
				transactionList.setBranch_Name(resultSet.getString("branch_Name"));
				transactionList.setTransaction_Date(resultSet.getString("date"));
				transactionList.setTransaction_Time(resultSet.getString("time"));
				transactionList.setEmployeeName(resultSet.getString("last_Name"));
				transactionList.setAmount(resultSet.getDouble("amount"));
				transactionList.setTransaction_Type(resultSet.getString("transaction_Name"));
				// Add book to list
				list.add(transactionList);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTransactionTypeID(String typeName) {
		int transactionId  = 0;
		String sql = "SELECT transaction_Type_ID FROM transaction_type WHERE transaction_type.transaction_Name = '"+typeName+"'";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			transactionId = resultSet.getInt(1);
			System.out.println("SQL: "+sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactionId;
	}

	@Override
	public int getAccountID(String accountNumber) {
		int accountId = 0;
		String sql = "SELECT * FROM account WHERE account.account_Number = "+accountNumber;
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			accountId = resultSet.getInt("account_ID");
//			System.out.println("SQL: "+sql);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("getAccountID error............");
			accountId = -1;
			e.printStackTrace();
		}
		return accountId;
	}

	@Override
	public boolean addTransaction(Transaction trans) {
		String sql;
		if(trans.getTransaction_Type_Id() == 1) {
			sql = "INSERT INTO transactions (account_ID,branch_ID,transaction_Type_ID,date,time,employee_ID,amount) "
					+ "VALUES("+trans.getAccount_ID()+","+trans.getBranch_ID()+","+trans.getTransaction_Type_Id()+",'"+trans.getDate()+"','"+trans.getTime()+"',"+trans.getEmployee_Id()+","+trans.getAmount()+")";
		}else {
			sql = "INSERT INTO transactions (account_ID,branch_ID,transaction_Type_ID,date,time,employee_ID,amount) "
					+ "VALUES("+trans.getAccount_ID()+","+trans.getBranch_ID()+","+trans.getTransaction_Type_Id()+",'"+trans.getDate()+"','"+trans.getTime()+"',"+trans.getEmployee_Id()+",-"+trans.getAmount()+")";
		}
				
		System.out.println("SQL: "+sql);
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
