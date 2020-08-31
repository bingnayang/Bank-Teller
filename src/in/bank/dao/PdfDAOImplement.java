package in.bank.dao;
import java.io.FileOutputStream;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDAOImplement implements PdfDAO {

	@Override
	public boolean printExamToPDF() {
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
          // Create Title
          Paragraph examTitle = new Paragraph("Bank of Teller",titleFront);
          examTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
          examTitle.setSpacingAfter(20f);
          document.add(examTitle);

          // Print questions and answer
//          for(Exam list:exams){
//              document.add(new Paragraph(list.getId()+") "+list.getQuestion()));
//              char option = 'a';
//              for(int i=0; i<list.getOption().size();i++){
//                  document.add(new Paragraph("["+option+"] "+list.getOption().get(i)+"\n"));
//                  option++;
//              }
//              document.add(new Paragraph("Answer: "+list.getAnswer()));
//              document.add(Chunk.NEWLINE);
//          }
          // Close
          document.close();
          System.out.println("Account Transaction PDF File Created");
      } catch (Exception e) {
          e.getMessage();
          return false;
      }
      return true;
	}

}
