/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class nhap2 {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("phieu_nhap_hang.pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.setPageSize(PageSize.A5);
            document.open();
            
            BaseFont unicodeFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(unicodeFont, 20, Font.BOLD);
            Font fontBold = new Font(unicodeFont, 14, Font.BOLD);
            Font font = new Font(unicodeFont, 14);
            
            Paragraph title = new Paragraph("THÔNG TIN SÁCH NHẬP \n", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(currentDate);
            String[] parts = date.split("/");
            String dateString = "Ngày " + parts[0] + " tháng " + parts[1] + " năm " + parts[2] + "\n\n\n";
            Paragraph dateParagraph = new Paragraph(dateString, font);
            dateParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(dateParagraph);
            
            PdfPTable tableUser = new PdfPTable(2);
            tableUser.setWidthPercentage(100);
            float[] columnWidthsUser = {30f, 70f};
            tableUser.setWidths(columnWidthsUser);
            
            PdfPCell cell = new PdfPCell();
            
            cell.setPhrase(new Phrase("Người lập phiếu: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Nguyen Van A", font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Nhà cung cấp:", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Nguyen Van A", font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Địa chỉ: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Hà Nội", font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            document.add(tableUser);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable table = new PdfPTable(3);
        
            cell.setPhrase(new Phrase("Ma"));
            cell.setBorder(PdfPCell.NO_BORDER); // Không hiển thị đường viền cho ô
            table.addCell(cell);

    //        table.addCell(new PdfPCell(new Phrase("Mã", font)));
            table.addCell(new PdfPCell(new Phrase("Tên", font)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", font)));

            table.addCell(new PdfPCell(new Phrase("1", font)));
            table.addCell(new PdfPCell(new Phrase("các thuộc tính", font)));
            table.addCell(new PdfPCell(new Phrase("10", font)));

            table.addCell(new PdfPCell(new Phrase("2", font)));
            table.addCell(new PdfPCell(new Phrase("có thể chứa nhiều", font)));
            table.addCell(new PdfPCell(new Phrase("11", font)));
            document.add(table);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableSignature = new PdfPTable(2);
            tableSignature.setWidthPercentage(100);
            float[] columnWidthsSignature = {65f, 35f};
            tableSignature.setWidths(columnWidthsSignature);
            
//            tableSignature.addCell(new PdfPCell(new Phrase("", font)));
//        tableSignature.addCell(new PdfPCell(new Phrase("Ngày " + parts[0] + " tháng " + parts[1] + " năm " + parts[2], font)));
//        
//        tableSignature.addCell(new PdfPCell(new Phrase("", font)));
//        tableSignature.addCell(new PdfPCell(new Phrase("Người lập phiêu", font)));
            
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase("Ngày " + parts[0] + " tháng " + parts[1] + " năm " + parts[2], font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase("Người lập phiếu", font));
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tableSignature.addCell(cell);
            
            
            document.add(tableSignature);
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
