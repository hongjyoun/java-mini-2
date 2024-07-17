package com.financemanager;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ConsoleManager consoleManager = new ConsoleManager();

    System.out.println("=========================================================");

    consoleManager.consoleController(scanner);

    System.out.println("=========================================================");
    scanner.close();
  }
}
