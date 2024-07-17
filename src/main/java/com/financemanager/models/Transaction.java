package com.financemanager.models;

import com.financemanager.enums.TransactionType;

import java.time.LocalDate;

public class Transaction {
  private int id;
  private TransactionType type;
  private Category category;
  private double amount;
  private LocalDate date;

  public Transaction() {
  }

//  public Transaction(int id, TransactionType type, Category category, double amount, LocalDate date) {
//    this.id = id;
//    this.type = type;
//    this.category = category;
//    this.amount = amount;
//    this.date = date;
//  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public TransactionType getType() {
    return this.type;
  }
}
