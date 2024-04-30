/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.BorrowReturn;
import model.ErrorBook;
import model.Import;
import model.ImportBook;
import model.Reader;
import model.Violation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ExportFile {
    public void exportImport(Import i){
        Document document = new Document();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("phieu_nhap_hang.pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.setPageSize(PageSize.A4);
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
            String dateString = "Ngày " + parts[0] + " tháng " + parts[1] + " năm " + parts[2];
            Paragraph dateParagraph = new Paragraph(dateString + "\n\n\n", font);
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
            
            cell.setPhrase(new Phrase(i.getUser().getFullname(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Nhà cung cấp:", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(i.getSupplier().getFullname(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Địa chỉ: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(i.getSupplier().getAddress(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            document.add(tableUser);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableBook = new PdfPTable(4);
            tableBook.setWidthPercentage(100);
            float[] columnWidthsBook = {10f, 50f, 20f, 20f};
            tableBook.setWidths(columnWidthsBook);
            
            tableBook.addCell(new PdfPCell(new Phrase("STT", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Tên sách", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Giá", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Số lượng", fontBold)));
            
            int index = 1;
            long amount = 0;
            for(ImportBook ib : i.getImportbook()){
                amount += ib.getPrice() * ib.getQuantity();
                tableBook.addCell(new PdfPCell(new Phrase(String.valueOf(index++), font)));
                tableBook.addCell(new PdfPCell(new Phrase(ib.getNamebook(), font)));
                tableBook.addCell(new PdfPCell(new Phrase(String.format("%,d", ib.getPrice()), font)));
                tableBook.addCell(new PdfPCell(new Phrase(String.valueOf(ib.getQuantity()), font)));
            }
            
            document.add(tableBook);
            
            document.add(new Paragraph("\n"));
            
            document.add(new Paragraph("Tổng tiền: " + String.format("%,d", amount) + " VND", fontBold));
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableSignature = new PdfPTable(2);
            tableSignature.setWidthPercentage(100);
            float[] columnWidthsSignature = {65f, 35f};
            tableSignature.setWidths(columnWidthsSignature);
            
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(dateString, font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase("Người lập phiếu", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tableSignature.addCell(cell);
            
            document.add(tableSignature);
            
            document.close();
        } catch (Exception e) {
        }
    }

    public void exportReportBookImport(Date date, Date date0, List<Import> listimport) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo sách nhập");
        
        XSSFRow row = null;
        Cell cell = null;
        
        row = sheet.createRow((short) 2);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));
        String title = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(date != null){
            title = "TỪ" + dateFormat.format(date) + " ĐẾN " + dateFormat.format(date0);
        }
        cell.setCellValue("THÔNG TIN SÁCH NHẬP " + title);
        
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(1, 10000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 2000);
        sheet.setColumnWidth(5, 3000);
        
        row = sheet.createRow((short) 4);
        cell = row.createCell(0, CellType.STRING);
        sheet.setColumnWidth(0, 50);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên sách");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Nhà cung cấp");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ngày nhập");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Số bản");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Giá tiền");
        
        int index = 1;
        for(Import i : listimport){
            for(ImportBook ib : i.getImportbook()){
                row = sheet.createRow((short) 4 + index);
                row.createCell(0).setCellValue(index++);
                row.createCell(1).setCellValue(ib.getNamebook());
                row.createCell(2).setCellValue(i.getSupplier().getFullname());
                row.createCell(3).setCellValue(dateFormat.format(i.getDeliverydate()));
                row.createCell(4).setCellValue(ib.getQuantity());
                row.createCell(5).setCellValue(ib.getPrice());
            }
        }
        try (FileOutputStream out = new FileOutputStream(new File("Sach_nhap.xlsx"))) {
            workbook.write(out);
        }
    }

    public void exportBorrow(Reader reader) {
        Document document = new Document();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("phieu_muon.pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.setPageSize(PageSize.A5.rotate());
            document.open();
            
            BaseFont unicodeFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(unicodeFont, 20, Font.BOLD);
            Font fontBold = new Font(unicodeFont, 14, Font.BOLD);
            Font font = new Font(unicodeFont, 14);
            
            Paragraph title = new Paragraph("THÔNG TIN SÁCH MƯỢN \n", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableUser = new PdfPTable(2);
            tableUser.setWidthPercentage(100);
            float[] columnWidthsUser = {30f, 70f};
            tableUser.setWidths(columnWidthsUser);
            
            PdfPCell cell = new PdfPCell();
            
            cell.setPhrase(new Phrase("Mã bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(reader.getReaderid(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Tên bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(reader.getFullname(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            document.add(tableUser);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableBook = new PdfPTable(5);
            tableBook.setWidthPercentage(100);
            float[] columnWidthsBook = {8f, 12f, 40f, 20f, 20f};
            tableBook.setWidths(columnWidthsBook);
            
            tableBook.addCell(new PdfPCell(new Phrase("STT", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Mã sách", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Tên sách", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Ngày mượn", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Hạn trả", fontBold)));
            
            int index = 1;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for(BorrowReturn br : new BorrowReturnDAO().getBorrowReturnNotReturnByReaderId(reader.getId())){
                tableBook.addCell(new PdfPCell(new Phrase(String.valueOf(index++), font)));
                tableBook.addCell(new PdfPCell(new Phrase(br.getAbook().getAbookid(), font)));
                tableBook.addCell(new PdfPCell(new Phrase(br.getAbook().getBook().getName(), font)));
                tableBook.addCell(new PdfPCell(new Phrase(dateFormat.format(new Date(br.getBorrowdate().getTime())), font)));
                tableBook.addCell(new PdfPCell(new Phrase(dateFormat.format(new Date(br.getDuedate().getTime())), font)));
            }
            
            document.add(tableBook);
            document.close();
        } catch (Exception e) {
        }
    }

    public void exportReturn(Reader reader, List<BorrowReturn> listreturn) {
        Document document = new Document();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("phieu_tra.pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.setPageSize(PageSize.A5.rotate());
            document.open();
            
            BaseFont unicodeFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(unicodeFont, 20, Font.BOLD);
            Font fontBold = new Font(unicodeFont, 14, Font.BOLD);
            Font font = new Font(unicodeFont, 14);
            
            Paragraph title = new Paragraph("THÔNG TIN SÁCH TRẢ \n", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableUser = new PdfPTable(2);
            tableUser.setWidthPercentage(100);
            float[] columnWidthsUser = {30f, 70f};
            tableUser.setWidths(columnWidthsUser);
            
            PdfPCell cell = new PdfPCell();
            
            cell.setPhrase(new Phrase("Mã bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(reader.getReaderid(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Tên bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(reader.getFullname(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            document.add(tableUser);
            
            document.add(new Paragraph("\n\n"));
            
            PdfPTable tableBook = new PdfPTable(5);
            tableBook.setWidthPercentage(100);
            float[] columnWidthsBook = {8f, 12f, 40f, 20f, 20f};
            tableBook.setWidths(columnWidthsBook);
            
            tableBook.addCell(new PdfPCell(new Phrase("STT", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Mã sách", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Tên sách", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Ngày mượn", fontBold)));
            tableBook.addCell(new PdfPCell(new Phrase("Ngày trả", fontBold)));
            
            int index = 1;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for(BorrowReturn br : listreturn){
                tableBook.addCell(new PdfPCell(new Phrase(String.valueOf(index++), font)));
                tableBook.addCell(new PdfPCell(new Phrase(br.getAbook().getAbookid(), font)));
                tableBook.addCell(new PdfPCell(new Phrase(br.getAbook().getBook().getName(), font)));
                tableBook.addCell(new PdfPCell(new Phrase(dateFormat.format(new Date(br.getBorrowdate().getTime())), font)));
                tableBook.addCell(new PdfPCell(new Phrase(dateFormat.format(new Date(br.getReturndate().getTime())), font)));
            }
            
            document.add(tableBook);
            document.close();
        } catch (Exception e) {
        }
    }

    public void exportViolation(Violation v) {
        Document document = new Document();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("phieu_vi_pham.pdf");
            PdfWriter.getInstance(document, fileOutputStream);
            document.setPageSize(PageSize.A4);
            document.open();
            
            BaseFont unicodeFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTitle = new Font(unicodeFont, 20, Font.BOLD);
            Font fontBold = new Font(unicodeFont, 14, Font.BOLD);
            Font font = new Font(unicodeFont, 14);
            
            
            Paragraph title = new Paragraph("BIÊN BẢN VI PHẠM \n", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            Date currentDate = v.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(currentDate);
            String[] parts = date.split("/");
            String dateString = "Ngày " + parts[0] + " tháng " + parts[1] + " năm " + parts[2];
            Paragraph dateParagraph = new Paragraph(dateString + "\n", font);
            dateParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(dateParagraph);
            
            document.add(new Paragraph("\n"));
            
            PdfPTable tableUser = new PdfPTable(2);
            tableUser.setWidthPercentage(100);
            float[] columnWidthsUser = {30f, 70f};
            tableUser.setWidths(columnWidthsUser);
            
            PdfPCell cell = new PdfPCell();
            
            cell.setPhrase(new Phrase("Mã bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(v.getReader().getReaderid(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Tên bạn đọc: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(v.getReader().getFullname(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase("Vi phạm: ", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            cell.setPhrase(new Phrase(v.getNote(), font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableUser.addCell(cell);
            
            document.add(tableUser);
            
            document.add(new Paragraph("\n"));
            
            Paragraph titleBook = new Paragraph("Thông tin sách vi phạm \n", fontBold);
            titleBook.setAlignment(Element.ALIGN_CENTER);
            document.add(titleBook);
            
            int index = 1;
            int amount = 0;
            for(BorrowReturn br : v.getBorrowReturn()){
                document.add(new Paragraph(index + ", Quyển " + index++ + " : ", font));
                document.add(new Paragraph("    Mã sách: " + br.getAbook().getAbookid(), font));
                document.add(new Paragraph("    Tên sách: " + br.getAbook().getBook().getName(), font));
                document.add(new Paragraph("    Ngày mượn: " + br.getBorrowdate(), font));
                document.add(new Paragraph("    Hạn trả: " + br.getDuedate(), font));
                document.add(new Paragraph("    Ngày trả: " + br.getReturndate(), font));
                document.add(new Paragraph("    Lỗi vi phạm: ", font));
                for(ErrorBook eb : br.getErrorBook()){
                    int price = eb.getPercentage() * br.getAbook().getBook().getPrice() / 100;
                    amount += price;
                    document.add(new Paragraph("         - " + eb.getName() + " - Phạt: " + String.format("%,d", price) + " VND ", font));
                }
                document.add(new Paragraph("\n"));
            }
            document.add(new Paragraph("\n"));
            
            
            document.add(new Paragraph("Tổng tiền: " + String.format("%,d", amount) + " VND", fontBold));
            
            document.add(new Paragraph("\n"));
            
            PdfPTable tableSignature = new PdfPTable(3);
            tableSignature.setWidthPercentage(100);
            float[] columnWidthsSignature = {35f, 30f, 35f};
            tableSignature.setWidths(columnWidthsSignature);
            
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(dateString, font));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            
            cell.setPhrase(new Phrase("Nguời vi phạm", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase(""));
            cell.setBorder(PdfPCell.NO_BORDER);
            tableSignature.addCell(cell);
            cell.setPhrase(new Phrase("Người lập biên bản", fontBold));
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tableSignature.addCell(cell);
            
            document.add(tableSignature);
            
            document.close();
        } catch (Exception e) {
        }
    }

    public void exportReportBorrow(List<BorrowReturn> listborrow) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo sách đang mượn");
        
        XSSFRow row = null;
        Cell cell = null;
        
        row = sheet.createRow((short) 1);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));
        cell.setCellValue("DANH SÁCH CÁC SÁCH ĐANG MƯỢN ");
        
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 3000);
        
        row = sheet.createRow((short) 4);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã sách");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Tên sách");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Bạn đọc");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày mượn");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Hạn trả");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int index = 1;
        for(BorrowReturn br : listborrow){
            row = sheet.createRow((short) 4 + index);
            row.createCell(0).setCellValue(index++);
            row.createCell(1).setCellValue(br.getAbook().getAbookid());
            row.createCell(2).setCellValue(br.getAbook().getBook().getName());
            row.createCell(3).setCellValue(br.getReader().getFullname());
            row.createCell(4).setCellValue(dateFormat.format(br.getBorrowdate()));
            row.createCell(5).setCellValue(dateFormat.format(br.getDuedate()));
        }
        
        row = sheet.createRow((short) 5+index);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(5+index, 5+index, 1, 4));
        cell.setCellValue("Tổng số sách mượn:   " + String.valueOf(listborrow.size()));
        
        try (FileOutputStream out = new FileOutputStream(new File("Sach_muon.xlsx"))) {
            workbook.write(out);
        }
    }

    public void exportReportReturn(List<BorrowReturn> listreturn) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo sách đã trả");
        
        XSSFRow row = null;
        Cell cell = null;
        
        row = sheet.createRow((short) 1);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));
        cell.setCellValue("DANH SÁCH CÁC SÁCH ĐÃ TRẢ");
        
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 3000);
        
        row = sheet.createRow((short) 4);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã sách");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Tên sách");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Bạn đọc");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày mượn");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Ngày trả");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int index = 1;
        for(BorrowReturn br : listreturn){
            row = sheet.createRow((short) 4 + index);
            row.createCell(0).setCellValue(index++);
            row.createCell(1).setCellValue(br.getAbook().getAbookid());
            row.createCell(2).setCellValue(br.getAbook().getBook().getName());
            row.createCell(3).setCellValue(br.getReader().getFullname());
            row.createCell(4).setCellValue(dateFormat.format(br.getBorrowdate()));
            row.createCell(5).setCellValue(dateFormat.format(br.getReturndate()));
        }
        
        row = sheet.createRow((short) 5+index);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(5+index, 5+index, 1, 4));
        cell.setCellValue("Tổng số sách trả:    " + String.valueOf(listreturn.size()));
        
        try (FileOutputStream out = new FileOutputStream(new File("Sach_tra.xlsx"))) {
            workbook.write(out);
        }
    }

    public void exportReportViolation(List<Violation> listviolation) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách biên bản");
        
        XSSFRow row = null;
        Cell cell = null;
        
        row = sheet.createRow((short) 1);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 4));
        cell.setCellValue("DANH SÁCH BIÊN BẢN VI PHẠM");
        
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 4000);
        
        row = sheet.createRow((short) 4);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Người vi phạm");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Nội dung");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Số lượng sách");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày trả");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Tổng tiền phạt");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int index = 1;
        int amount = 0;
        int quantityBook = 0;
        for(Violation v : listviolation){
            quantityBook += v.getBorrowReturn().size();
            int price = 0;
            for(BorrowReturn br : v.getBorrowReturn()){
                for(ErrorBook eb : br.getErrorBook()){
                    price = eb.getPercentage() * br.getAbook().getBook().getPrice() / 100;
                    amount += price;
                }
            }
            
            row = sheet.createRow((short) 4 + index);
            row.createCell(0).setCellValue(index++);
            row.createCell(1).setCellValue(v.getReader().getFullname());
            row.createCell(2).setCellValue(v.getNote());
            row.createCell(3).setCellValue(v.getBorrowReturn().size());
            row.createCell(4).setCellValue(dateFormat.format(v.getDate()));
            row.createCell(5).setCellValue(price);
        }
        
        row = sheet.createRow((short) 5+index);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(5+index, 5+index, 1, 4));
        cell.setCellValue("Tổng số biên bản:    " + String.valueOf(listviolation.size()));
        
        index++;
        row = sheet.createRow((short) 5+index);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(5+index, 5+index, 1, 4));
        cell.setCellValue("Tổng số sách lỗi:    " + String.valueOf(quantityBook));
        
        index++;
        row = sheet.createRow((short) 5+index);
        cell = row.createCell(1, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(5+index, 5+index, 1, 4));
        cell.setCellValue("Tổng tiền đền bù:    " + String.format("%,d", amount) + " VND ");
        
        try (FileOutputStream out = new FileOutputStream(new File("DS_bien_ban.xlsx"))) {
            workbook.write(out);
        }
    }
    
    
}
