# 콘솔 기반 개인 재무 관리 시스템 프로젝트 가이드라인

## 1. 프로젝트 개요
이 프로젝트는 콘솔 인터페이스를 통해 사용자의 개인 재무를 관리하는 Java 애플리케이션입니다. 수입과 지출을 추적하고, 간단한 재무 보고서를 생성할 수 있습니다.

## 2. 주요 기능
1. 거래 기록 관리 (추가, 수정, 삭제, 조회)
2. 카테고리 관리 (수입/지출 카테고리 설정)
3. 월간/연간 재무 요약 보고서 생성
4. 데이터 파일 저장 및 로드
5. 간단한 예산 설정 및 추적

## 3. 프로젝트 구조
```
src/
  └── main/
      └── java/
          └── com/
              └── financemanager/
                  ├── model/
                  │   ├── Transaction.java
                  │   └── Category.java
                  ├── service/
                  │   ├── TransactionService.java
                  │   └── CategoryService.java
                  ├── util/
                  │   ├── FileManager.java
                  │   └── ReportGenerator.java
                  ├── Main.java
                  └── FinanceManagerCLI.java
```

## 4. 클래스 설계

### 4.1 Model 클래스
```java
public class Transaction {
    private UUID id;
    private LocalDate date;
    private String description;
    private BigDecimal amount;
    private Category category;
    private boolean isIncome;

    // 생성자, getter, setter, toString 메서드
}

public class Category {
    private String name;
    private boolean isIncomeCategory;

    // 생성자, getter, setter, toString 메서드
}
```

### 4.2 Service 클래스
```java
public class TransactionService {
    private List<Transaction> transactions;

    public void addTransaction(Transaction transaction) { /* ... */ }
    public void deleteTransaction(UUID id) { /* ... */ }
    public List<Transaction> getAllTransactions() { /* ... */ }
    public List<Transaction> getTransactionsByMonth(int year, int month) { /* ... */ }
    // 기타 필요한 메서드들
}

public class CategoryService {
    private List<Category> categories;

    public void addCategory(Category category) { /* ... */ }
    public List<Category> getAllCategories() { /* ... */ }
    // 기타 필요한 메서드들
}
```

### 4.3 Util 클래스
```java
public class FileManager {
    public void saveData(List<Transaction> transactions, List<Category> categories) { /* ... */ }
    public Map<String, List<?>> loadData() { /* ... */ }
}

public class ReportGenerator {
    public String generateMonthlyReport(List<Transaction> transactions, int year, int month) { /* ... */ }
    public String generateYearlyReport(List<Transaction> transactions, int year) { /* ... */ }
}
```

### 4.4 Main 클래스
```java
public class Main {
    public static void main(String[] args) {
        FinanceManagerCLI cli = new FinanceManagerCLI();
        cli.run();
    }
}
```

### 4.5 CLI 클래스
```java
public class FinanceManagerCLI {
    private TransactionService transactionService;
    private CategoryService categoryService;
    private FileManager fileManager;
    private ReportGenerator reportGenerator;
    private Scanner scanner;

    public void run() {
        // 메인 메뉴 및 사용자 입력 처리
    }

    private void showMainMenu() { /* ... */ }
    private void handleAddTransaction() { /* ... */ }
    private void handleViewTransactions() { /* ... */ }
    private void handleGenerateReport() { /* ... */ }
    // 기타 필요한 메서드들
}
```

## 5. 구현 가이드라인

### 5.1 데이터 저장 및 로드
- JSON 형식으로 데이터를 파일에 저장합니다.
- Jackson 라이브러리를 사용하여 객체를 JSON으로, JSON을 객체로 변환합니다.

### 5.2 사용자 인터페이스
- Scanner 클래스를 사용하여 사용자 입력을 받습니다.
- 메인 메뉴를 통해 다양한 기능에 접근할 수 있도록 합니다.

### 5.3 거래 및 카테고리 관리
- List 인터페이스를 사용하여 거래와 카테고리를 관리합니다.
- Stream API를 활용하여 데이터를 필터링하고 처리합니다.

### 5.4 보고서 생성
- StringBuilder를 사용하여 보고서 문자열을 효율적으로 생성합니다.
- Java 8의 날짜/시간 API를 활용하여 날짜 계산을 수행합니다.

### 5.5 예외 처리
- 사용자 입력 오류, 파일 I/O 오류 등에 대한 예외 처리를 구현합니다.
- 사용자 정의 예외를 생성하여 특정 비즈니스 로직 오류를 처리합니다.

## 6. 개발 단계
1. 기본 클래스 구조 설계 및 구현
2. 파일 I/O 기능 구현
3. 거래 및 카테고리 관리 기능 구현
4. 보고서 생성 기능 구현
5. 사용자 인터페이스 (CLI) 구현
6. 예외 처리 및 입력 검증 추가
7. 테스트 및 디버깅
8. 문서화

## 7. 추가 도전 과제 (선택적)
1. 람다식과 스트림 API를 활용한 데이터 분석 기능 추가
2. 멀티스레딩을 활용한 백그라운드 자동 저장 기능 구현
3. 디자인 패턴 (예: 싱글톤, 팩토리, 옵저버) 적용
4. 제네릭을 활용한 범용 데이터 처리 클래스 구현

## 8. 주의사항
- 모듈화와 재사용성을 고려한 코드 설계
- 적절한 주석 작성 및 명확한 변수/메서드 명명
- 일관된 코딩 스타일 유지
- 사용자 입력에 대한 철저한 검증

이 프로젝트를 통해 Java의 핵심 기능을 실제 애플리케이션에 적용하는 경험을 쌓을 수 있습니다.