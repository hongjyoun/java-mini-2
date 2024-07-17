package com.financemanager;

import com.financemanager.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
  List<Transaction> transactions = new ArrayList<>();

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

}
