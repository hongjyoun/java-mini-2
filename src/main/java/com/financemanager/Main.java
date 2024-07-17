package com.financemanager;

import com.financemanager.enums.TransactionType;
import com.financemanager.models.Transaction;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    System.out.println("=========================================================");


    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("어떤 항목을 입력하시겠습니까? \n- 입금: I\n- 지출: E");
      String input = scanner.nextLine();

      if(input == "exit") break;
      else if(input == "I") {
        Transaction transaction = new Transaction();
        transaction.setType(TransactionType.INCOME);
        System.out.println(transaction.getType());
      }
    }

    System.out.println("=========================================================");


//    int id = 1;
//    TransactionType type = TransactionType.INCOME;
//    Category category = IncomeCategory.BONUS;
//    double amount = 1000.0;
//    LocalDate date = LocalDate.now();
//    Transaction transaction = new Transaction(id, type, category, amount, date);





  }
}
