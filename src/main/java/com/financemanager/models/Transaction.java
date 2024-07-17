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

  public Transaction(TransactionType type, Category category, double amount, LocalDate date) {
    this.id = 1;
    this.type = type;
    this.category = category;
    this.amount = amount;
    this.date = date;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }
  public void setCategory(Category category) {
    this.category = category;
  }

  public TransactionType getType() {
    return this.type;
  }
  public Category getCategory() {
    return this.category;
  }
  public LocalDate getDate() {
    return this.date;
  }
  public double getAmount() {
    return this.amount;
  }

  @Override
  public String toString() {
    return String.format("%s | %s | %s | %.2f",
      getDate(), getType(), getCategory(), getAmount());
  }
}
