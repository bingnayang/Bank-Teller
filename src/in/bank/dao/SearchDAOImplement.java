package in.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.bank.entity.AccountInfo;
import in.bank.util.DBConnectionUtil;

public class SearchDAOImplement implements SearchDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public AccountInfo searchAccount(AccountInfo name) {
		AccountInfo account = null;
		String sql = "SELECT * from accountInfo WHERE first_Name = '"+name.getFirstName()+"' AND last_Name = '"+name.getLastName()+"'";
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
				account.setAccountNumber(resultSet.getInt("account_Number"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return account;
	}

}
