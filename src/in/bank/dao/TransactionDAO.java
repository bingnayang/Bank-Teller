package in.bank.dao;

import in.bank.entity.AccountInfo;

public interface TransactionDAO {
	AccountInfo getAccount(String firstName, String lastName, String accountNumber);
	double getBalance(String accountNumber);
}
