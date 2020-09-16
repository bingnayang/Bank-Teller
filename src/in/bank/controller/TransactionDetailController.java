package in.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionDetailController
 */
public class TransactionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transactionId = request.getParameter("id");
		System.out.println(transactionId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/transaction-detail.jsp");
		dispatcher.forward(request,response);
	}


}
