package in.bank.dao;

import java.util.List;

import in.bank.entity.AccountInfo;
import in.bank.entity.Transaction;
import in.bank.entity.TransactionInfo;

public interface TransactionDAO {
	AccountInfo getAccount(String firstName, String lastName, String accountNumber);
	boolean addTransaction(Transaction trans);
	List<TransactionInfo> getTransactionList(String accountNumber);
	double getBalance(String accountNumber);
	int getTransactionTypeID(String typeName);
	int getAccountID(String accountNumber);
	TransactionInfo getTransactionDetail(String transactionId);
}
