package com.financemanager;

import com.financemanager.enums.ExpenseCategory;
import com.financemanager.enums.IncomeCategory;
import com.financemanager.enums.TransactionType;
import com.financemanager.models.Category;
import com.financemanager.models.Transaction;
import com.financemanager.service.TransactionService;
import com.financemanager.utils.ExcelSaver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static com.financemanager.utils.ExcelSaver.saveToExcel;

public class CLIManager {
  private int menu = 0;
  boolean isExit = false;

  TransactionService transactionManager = new TransactionService();

  private void setMenu(int menu) {
    this.menu = menu;
  }

  public void consoleController(Scanner scanner) {
    
    while(isExit == false) {
      switch(menu) {
        case 0:
          this.infoView(scanner);
          break;
        case 1:
          this.inputForm(scanner);
          break;
        case 2:
          this.showList();
          break;
        case 3:
          this.saveExcel();
          break;
        default:
          isExit = true;
          break;
      }
    }
    System.out.println("서비스를 종료합니다.");
  }

  private void infoView(Scanner scanner) {
    while(isExit == false && menu == 0) {
      System.out.println("메뉴를 선택해주세요 \n1. 입력\n2. 목록보기\n3. 목록을 엑셀로 출력하기\n4. 종료하기");
      String input = scanner.nextLine().trim();
      switch (input) {
        case "1": this.setMenu(1); break;
        case "2": this.setMenu(2); break;
        case "3": this.setMenu(3); break;
        case "4": isExit = true; break;
        default: System.out.println("잘못된 메뉴 선택입니다. 다시 시도해주세요."); break;
      }
    }
  }

  private void inputForm(Scanner scanner) {
    if(isExit == true || menu != 1) return;

    TransactionType type = null;
    Category category = null;
    double amount = 0;
    LocalDate date = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    while (type == null || category == null || amount == 0 || date == null) {
      if(type == null) {
        System.out.println("어떤 항목을 입력하시겠습니까? \n1. 입금\n2. 지출\n");
        String input = scanner.nextLine().trim();
        switch (input) {
          case "1": type = TransactionType.INCOME; break;
          case "2": type = TransactionType.EXPENSE; break;
          default: System.out.println("잘못된 항목입니다. 다시 시도해주세요.\n");
        }
      } else if (category == null && type.equals(TransactionType.INCOME)) {
        System.out.println("카테고리를 선택해주세요 \n1. 급여\n2. 보너스\n3. 투자수익\n4. 사업소득\n5 기타수익\n");
        String input = scanner.nextLine().trim();
        switch (input) {
          case "1": category = IncomeCategory.SALARY; break;
          case "2": category = IncomeCategory.BONUS; break;
          case "3": category = IncomeCategory.INVESTMENT; break;
          case "4": category = IncomeCategory.BUSINESS; break;
          case "5": category = IncomeCategory.OTHER; break;
          default: System.out.println("잘못된 항목입니다. 다시 시도해주세요.\n");
        }
      } else if (category == null && type.equals(TransactionType.EXPENSE)) {
        System.out.println("카테고리를 선택해주세요 \n1. 주거비\n2. 식비\n3. 교통비\n4. 공과금\n5. 의료비\n6. 여가비\n7. 기타\n");
        String input = scanner.nextLine().trim();
        switch (input) {
          case "1": category = ExpenseCategory.HOUSING; break;
          case "2": category = ExpenseCategory.FOOD; break;
          case "3": category = ExpenseCategory.TRANSPORTATION; break;
          case "4": category = ExpenseCategory.UTILITIES; break;
          case "5": category = ExpenseCategory.HEALTHCARE; break;
          case "6": category = ExpenseCategory.ENTERTAINMENT; break;
          case "7": category = ExpenseCategory.OTHER; break;
          default: System.out.println("잘못된 카테고리입니다. 다시 시도해주세요.\n");
        }
      } else if (amount == 0) {
        System.out.println("금액을 입력해주세요.");
        String input = scanner.nextLine().trim();
        try {
          if(Double.parseDouble(input) == 0) System.out.println("숫자는 0 이상 입력해주세요.\n");
          else amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
          System.out.println("잘못된 거래유형입니다. 다시 입력해주세요.\n");
        }
      } else if (date == null) {
        System.out.println("날짜를 입력해주세요 ex) 2024-01-01");
        String input = scanner.nextLine().trim();
        try {
          date = LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e){
          System.out.println("오류: 잘못된 날짜 형식입니다.");
          System.out.println("YYYY-MM-DD 형식으로 다시 입력해주세요. (예: 2023-05-15)\n");
          continue;
        }
        if(date.isAfter(LocalDate.now())) {
          System.out.println("오류: 미래의 날짜는 입력할 수 없습니다.\n");
          date = null;
        }
      }
    }

    Transaction transaction = new Transaction(type, category, amount, date);
    transactionManager.addTransaction(transaction);
    System.out.println("다음과 같이 저장되었습니다.");
    System.out.println(transaction + "\n");
    setMenu(0);
  }

  private void showList() {
    while(isExit == false && menu == 2) {
      System.out.println("========= 현재까지의 금전내역입니다. =========");
      for(Transaction transaction : transactionManager.getTransactions()) {
        System.out.println(transaction);
      }
      System.out.println("==========================================");
      System.out.println();
      setMenu(0);
    }
  }

  private void saveExcel() {
    ExcelSaver excelSaver = new ExcelSaver();
    excelSaver.saveToExcel(transactionManager.getTransactions());
    setMenu(0);
  }



}
