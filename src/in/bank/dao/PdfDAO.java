package in.bank.dao;

import java.util.List;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

import in.bank.entity.AccountInfo;
import in.bank.entity.TransactionInfo;

public interface PdfDAO {
	AccountInfo getAccountInfo(String accountNumber);
	boolean printExamToPDF(AccountInfo accountInfo,List<TransactionInfo> accountTransactionList);

}
