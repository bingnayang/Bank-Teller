package in.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.bank.dao.SearchDAO;
import in.bank.dao.SearchDAOImplement;
import in.bank.entity.AccountInfo;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SearchDAO searchDAO = null;

    public SearchController() {
    	searchDAO = new SearchDAOImplement();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("Search Account Number By: "+firstName+" "+lastName);
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setFirstName(firstName);
		accountInfo.setLastName(lastName);
		AccountInfo account = searchDAO.searchAccount(accountInfo);
		System.out.println("Account Number: "+account.getAccountNumber());
		
		request.setAttribute("account",account);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/teller-mode.jsp");
		dispatcher.forward(request,response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
