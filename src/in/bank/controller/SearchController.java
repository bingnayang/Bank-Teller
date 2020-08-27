package in.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bank.dao.TransactionDAO;
import in.bank.dao.TransactionDAOImplement;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TransactionDAO accountDAO = null;

    public SearchController() {
    	accountDAO = new TransactionDAOImplement();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("Search Account Number By: "+firstName+" "+lastName);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/teller-mode.jsp");
		dispatcher.forward(request,response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
