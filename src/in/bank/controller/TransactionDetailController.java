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
import in.bank.entity.TransactionInfo;

/**
 * Servlet implementation class TransactionDetailController
 */
public class TransactionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDAO transactionDAO = null;

    public TransactionDetailController() {
    	transactionDAO = new TransactionDAOImplement();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transactionId = request.getParameter("id");
//		System.out.println(transactionId);
		
		TransactionInfo transactionDetail = transactionDAO.getTransactionDetail(transactionId);
//		System.out.println("Account #: "+transactionDetail.getAccount_Number());
//		System.out.println("Branch Name: "+transactionDetail.getBranch_Name());
		
		request.setAttribute("transactionDetail",transactionDetail );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/transaction-detail.jsp");
		dispatcher.forward(request,response);
	}


}
