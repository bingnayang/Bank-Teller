package in.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bank.dao.TransactionDAO;
import in.bank.dao.TransactionDAOImplement;
import in.bank.entity.AccountInfo;
import in.bank.entity.TransactionInfo;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TransactionDAO accountDAO = null;

    public TransactionController() {
    	accountDAO = new TransactionDAOImplement();
    }
    

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amountInput = req.getParameter("amount");
		String transType = req.getParameter("transactionType");
		
		System.out.println("Transaction: "+transType);
		System.out.println("Amount Input: "+amountInput);
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String accountNumber = request.getParameter("accountNumber");
		
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Account Number: "+accountNumber);
		
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

	}



	
}
