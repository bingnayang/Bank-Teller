package in.bank.dao;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

import in.bank.entity.AccountInfo;
import in.bank.entity.TransactionInfo;
import in.bank.util.DBConnectionUtil;

public class PdfDAOImplement implements PdfDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	
	@Override
	public boolean printExamToPDF(AccountInfo accountInfo,List<TransactionInfo> accountTransactionList,double balance) {				
      String dest = "/Users/Bing/eclipse-workspace/Bank-Teller/AccountInfo.pdf";
      com.itextpdf.text.Document document = new com.itextpdf.text.Document();

      try {
          PdfWriter.getInstance(document, new FileOutputStream(dest));  

          // Open
          document.open();
          // Setup font for title
          Font titleFront = new Font();
          titleFront.setStyle(Font.BOLD);
          titleFront.setSize(20);
          Font subTitleFront = new Font();
          subTitleFront.setStyle(Font.BOLD);
          subTitleFront.setSize(16);

          // Create Title
          Paragraph personalinfo = new Paragraph("Bank of Teller",titleFront);
          personalinfo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
          personalinfo.setSpacingAfter(20f);
          document.add(personalinfo);
          
          //Print Account information
          document.add(new Paragraph("----------------------------------------"));
          document.add(new Paragraph("Name: "+accountInfo.getFirstName()+" "+accountInfo.getLastName()));
          document.add(new Paragraph("Account Number: "+accountInfo.getAccountNumber()));
          document.add(new Paragraph("----------------------------------------"));        
          
          //Create Account transaction section
          Paragraph accountTransaction = new Paragraph("Transactions",subTitleFront);
          accountTransaction.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
          accountTransaction.setSpacingAfter(20f);
          document.add(accountTransaction);
          
          //Print Account transaction
          for(TransactionInfo list:accountTransactionList) {
              document.add(new Paragraph(list.getTransaction_Date()+" | "+list.getTransaction_Type()+" | $ "+list.getAmount()));
          }
    
          //Create Account transaction section
          Paragraph accountBalance = new Paragraph("Balance",subTitleFront);
          accountBalance.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
          accountBalance.setSpacingAfter(20f);
          document.add(accountBalance);
          
          // Print balance
          document.add(new Paragraph("$"+balance));  
          
          // Close
          document.close();
          System.out.println("Account Transaction PDF File Created");
      } catch (Exception e) {
          e.getMessage();
          return false;
      }
      return true;
	}
	@Override
	public AccountInfo getAccountInfo(String accountNumber) {
		AccountInfo account = null;
		String sql = "SELECT * from accountInfo WHERE account_Number = '"+accountNumber+"'";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			while(resultSet.next()) {
				account = new AccountInfo();
				account.setFirstName(resultSet.getString("first_Name"));
				account.setLastName(resultSet.getString("last_Name"));
				account.setAccountNumber(resultSet.getInt("account_Number"));
				account.setAccountType(resultSet.getString("type_Name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return account;
	}

}
