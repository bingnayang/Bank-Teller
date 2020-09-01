package in.bank.dao;

import in.bank.entity.AccountInfo;

public interface PdfDAO {
	AccountInfo getAccountInfo(String accountNumber);
	boolean printExamToPDF(AccountInfo accountInfo);
}
