package in.bank.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bank.dao.TransactionDAO;
import in.bank.dao.TransactionDAOImplement;
import in.bank.entity.AccountInfo;
import in.bank.entity.Transaction;
import in.bank.entity.TransactionInfo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TransactionDAO accountDAO = null;

    public TransactionController() {
    	accountDAO = new TransactionDAOImplement();
    }
    

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String accountNumberInput = req.getParameter("accountNumber");
		String accountFirstNameInput = req.getParameter("accountFirstName");
		String accountLastNameInput = req.getParameter("accountLastName");
		double amountInput = Double.parseDouble(req.getParameter("amount"));
		String transType = req.getParameter("transactionType");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		
		int accountID = accountDAO.getAccountID(accountNumberInput);
		int transactionTypeID = accountDAO.getTransactionTypeID(transType);
		
		// Harding coding for now
		int branchId = 103;
		int employeeId = 8;

		//Testing
		System.out.println("=====================================");
		System.out.println("Account Number: "+ accountNumberInput+" | Account Id: "+accountID);
		System.out.println("Amount: "+ amountInput);
		System.out.println("Transaction Type: "+ transType+" | Transaction Id: "+transactionTypeID);
		System.out.println("Date: "+currentDate+"| Time: "+currentTime.format(formatter));
		System.out.println("=====================================");

		Transaction transaction = new Transaction();
		transaction.setAccount_ID(accountID);
		transaction.setBranch_ID(branchId);
		transaction.setTransaction_Type_Id(transactionTypeID);
		transaction.setDate(currentDate.toString());
		transaction.setTime(currentTime.format(formatter));
		transaction.setEmployee_Id(employeeId);
		transaction.setAmount(amountInput);
		
		
		boolean testing = accountDAO.addTransaction(transaction);
		System.out.println("Add Transaction: "+testing);
		
		// Redirect page
		resp.sendRedirect("TransactionController?firstName="+accountFirstNameInput+"&lastName="+accountLastNameInput+"&accountNumber="+accountNumberInput);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String accountNumber = request.getParameter("accountNumber");
		
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Account Number: "+accountNumber);
		
		try {
		AccountInfo accountInfo = accountDAO.getAccount(firstName,lastName,accountNumber);
		double balance = accountDAO.getBalance(accountNumber);
		accountInfo.setAccountBalance(balance);
		List<TransactionInfo> accountTransactionList = accountDAO.getTransactionList(accountNumber);
//		System.out.println("First Name: "+accountInfo.getFirstName());
//		System.out.println("Last Name: "+accountInfo.getLastName());
//		System.out.println("Account Number: "+accountInfo.getAccountNumber());
//		System.out.println("Account Type: "+accountInfo.getAccountType());
				
		request.setAttribute("accountTransactionList",accountTransactionList);	
		request.setAttribute("accountInfo",accountInfo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/account-view.jsp");
		dispatcher.forward(request,response);
		
		}catch(NullPointerException e) {
			System.out.println(e);
			System.out.println("No such account");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/teller-mode.jsp");
			dispatcher.forward(request,response);
			
		}

	}
	
}
