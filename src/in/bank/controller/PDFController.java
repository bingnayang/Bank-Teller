package in.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bank.dao.PdfDAO;
import in.bank.dao.PdfDAOImplement;
import in.bank.dao.SearchDAO;
import in.bank.dao.SearchDAOImplement;
import in.bank.dao.TransactionDAO;
import in.bank.dao.TransactionDAOImplement;
import in.bank.entity.AccountInfo;
import in.bank.entity.TransactionInfo;


public class PDFController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PdfDAO pdfDAO = null;
	TransactionDAO accountDAO = null;

    public PDFController() {
    	pdfDAO = new PdfDAOImplement();
    	accountDAO = new TransactionDAOImplement();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumberInput = request.getParameter("accountNumber");
		System.out.println("Account Number: "+ accountNumberInput);
		AccountInfo accountInfo = pdfDAO.getAccountInfo(accountNumberInput);
		List<TransactionInfo> transactionList = accountDAO.getTransactionList(accountNumberInput);
		// Send accountInfo to pdf
		boolean account = pdfDAO.printExamToPDF(accountInfo,transactionList);
		
//		request.sendRedirect("TransactionController?firstName="+accountFirstNameInput+"&lastName="+accountLastNameInput+"&accountNumber="+accountNumberInput);

		
	}

}
