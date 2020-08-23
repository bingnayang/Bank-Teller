package in.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.bank.entity.AccountInfo;

public class TransactionDAOImplement implements TransactionDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	
	@Override
	public AccountInfo getAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
