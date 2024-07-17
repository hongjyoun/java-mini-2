package com.financemanager.enums;

public enum TransactionType {
  INCOME("수입"),
  EXPENSE("지출");

  private String displayName;

  TransactionType(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return this.displayName;
  }
}
