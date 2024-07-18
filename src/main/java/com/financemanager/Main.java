package com.financemanager;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    CLIManager cliManager = new CLIManager();

    System.out.println("=========================================================");

    cliManager.consoleController(scanner);

    System.out.println("=========================================================");
    scanner.close();
  }
}
