package Utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.LoanSchedule;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDFCreator {
    public void create(ArrayList<LoanSchedule> loanSchedules) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("LoanSchedule.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(5);
        table.addCell("Nr raty");
        table.addCell("Kwota kapitalu");
        table.addCell("Kwota odsetek");
        table.addCell("Oplaty stale");
        table.addCell("Calkowita kwota raty");
        table.setHeaderRows(1);

        for(int i = 0; i < loanSchedules.size(); i++){
            table.addCell((i+1) + "");
            table.addCell(loanSchedules.get(i).getCapital() + "zl");
            table.addCell(loanSchedules.get(i).getInterest() + "zl");
            table.addCell(loanSchedules.get(i).getFixedFee() + "zl");
            table.addCell(loanSchedules.get(i).getFinalInstallment() + "zl");
        }

        document.add(table);
        document.close();
    }
}
