package com.financemanager.enums;
import com.financemanager.models.Category;

public enum IncomeCategory implements Category {
  SALARY("급여"),
  BONUS("보너스"),
  INVESTMENT("투자수익"),
  BUSINESS("사업소득"),
  OTHER("기타수입");

  private final String displayName;

  IncomeCategory(String displayName) {
    this.displayName = displayName;
  }
  public String getDisplayName() {
    return this.displayName;
  }
}
