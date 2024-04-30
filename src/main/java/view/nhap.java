/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 *
 * @author Admin
 */
public class nhap {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Học viên");

        XSSFRow row = null;
        Cell cell = null;

        
        spreadsheet.setColumnWidth(0, 1500);
        spreadsheet.setColumnWidth(1, 10000);
        spreadsheet.setColumnWidth(2, 5000);
        spreadsheet.setColumnWidth(3, 4000);
        spreadsheet.setColumnWidth(4, 3000);
        spreadsheet.setColumnWidth(5, 2000);
        row = spreadsheet.createRow((short) 2);
        row.setHeight((short) 500);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("DANH SÁCH HỌC VIÊN");

        row = spreadsheet.createRow((short) 3);
        row.setHeight((short) 500);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Họ và tên");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Ngày sinh");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Giới tính");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Số điện thoại");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Địa chỉ");

//        HocVienService hocVienService = new HocVienServiceImpl();
//
//        List<HocVien> listItem = hocVienService.getList();
//
//        for (int i = 0; i < listItem.size(); i++) {
//            HocVien hocVien = listItem.get(i);
//            row = spreadsheet.createRow((short) 4 + i);
//            row.setHeight((short) 400);
//            row.createCell(0).setCellValue(i + 1);
//            row.createCell(1).setCellValue(hocVien.getHo_ten());
//            row.createCell(2).setCellValue(hocVien.getNgay_sinh().toString());
//            row.createCell(3).setCellValue(hocVien.isGioi_tinh() ? "Nam" : "Nữ");
//            row.createCell(4).setCellValue(hocVien.getSo_dien_thoai());
//            row.createCell(5).setCellValue(hocVien.getDia_chi());
//        }

        FileOutputStream out = new FileOutputStream(new File("hv.xlsx"));
        workbook.write(out);
        out.close();
    }
    
}
