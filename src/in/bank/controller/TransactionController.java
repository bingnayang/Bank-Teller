package in.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      


//    public TransactionController() {
//    	
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String accountNumber = request.getParameter("accountNumber");
		
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Account Number: "+accountNumber);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/teller-mode.jsp");
		dispatcher.forward(request,response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
