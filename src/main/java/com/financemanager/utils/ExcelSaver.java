package com.financemanager.utils;

import com.financemanager.models.Transaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelSaver {

  public static void saveToExcel(List<Transaction> transactions) {
    try {
      String filePath = "C:\\Users\\hongj\\OneDrive\\Desktop\\file.xlsx";
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("Transactions");

      // 헤더 생성
      Row headerRow = sheet.createRow(0);
      headerRow.createCell(0).setCellValue("Date");
      headerRow.createCell(1).setCellValue("Type");
      headerRow.createCell(2).setCellValue("Category");
      headerRow.createCell(3).setCellValue("Amount");

      // 데이터 입력
      int rowNum = 1;
      for(Transaction transaction : transactions) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(transaction.getDate().toString());
        row.createCell(1).setCellValue(transaction.getType().toString());
        row.createCell(2).setCellValue(transaction.getCategory().toString());
        row.createCell(3).setCellValue(transaction.getAmount());
      }

      // 열 너비 자동 조정
      for (int i = 0; i < 4; i++) {
        sheet.autoSizeColumn(i);
      }

      // 파일 저장
      try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
        workbook.write(outputStream);
      }

      System.out.println("Excel file saved successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
