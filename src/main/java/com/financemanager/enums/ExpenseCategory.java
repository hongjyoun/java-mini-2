package com.financemanager.enums;
import com.financemanager.models.Category;

public enum ExpenseCategory implements Category {
  HOUSING("주거비"),
  FOOD("식비"),
  TRANSPORTATION("교통비"),
  UTILITIES("공과금"),
  HEALTHCARE("의료비"),
  ENTERTAINMENT("여가비"),
  EDUCATION("교육비"),
  SAVINGS("저축"),
  OTHER("기타");

  private final String displayName;

  ExpenseCategory(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return this.displayName;
  }
}
