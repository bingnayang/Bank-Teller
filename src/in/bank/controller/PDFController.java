package in.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bank.dao.PdfDAO;
import in.bank.dao.PdfDAOImplement;


public class PDFController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PdfDAO pdfDAO = null;

    public PDFController() {
    	pdfDAO = new PdfDAOImplement();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumberInput = request.getParameter("accountNumber");
		System.out.println("Account Number: "+ accountNumberInput);

		
	}

}
