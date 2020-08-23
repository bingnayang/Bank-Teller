package in.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import in.bank.entity.AccountInfo;
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
	
	

}
