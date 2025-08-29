## 미니 프로젝트 주제: 콘솔 은행 시스템

### 1. 프로젝트 개요

**목표**: 
* 자바 객체지향 프로그래밍(OOP)의 핵심 요소(클래스, 객체, 상속, 다형성)을 이해하고 활용합니다.
* `List`, `Map`과 같은 컬렉션 프레임워크를 사용하여 고객·계좌를 관리합니다. (`Map<Long, Customer>`, `Map<String, Account>`)
* 콘솔 입출력을 통해 사용자로부터 데이터를 받고 결과를 출력하는 프로그램을 만듭니다.


**개발 환경**:
* Java (JDK 21)
* IDE (IntelliJ)


### 2. 구현할 기능

사용자는 콘솔 메뉴를 통해 다음과 같은 기능을 실핼할 수 있습니다.

* 고객(Customer) 등록/조회
* 계좌(Account) 개설/조회/삭제 (계좌번호 자동 발급)
* 입금/출금 (잔액 부족 시 예외 처리)
* 송금
* 전체 고객 목록/개별 고객의 보유 계좌 목록 조회
* 프로그램 종료


**활용 포인트**
* `List`, `Map`으로 고객·계좌 관리 (`Map<Interger, Customer>`, `Map<String, Account>`)
* `추상 클래스 Account` → `CheckingAccount`(입출금), `SavingsAccount`(예금) 등 하위 클래스
* `인터페이스 Transferable`(선택) → `transfer(from, to, amount)` 다형성


### 3. 클래스 설계

이 프로젝트는 4개의 주요 클래스로 구성됩니다.

---

#### 3-1. `Customer` 클래스

고객 한 명의 정보를 담는 데이터 객체입니다.

* **속성 (Fields)**
  * `customerId`: 고객 번호 (int)
  * `name`: 고객 이름 (String)
  * `accounts`: 보유 계좌 목록 (List<Account>)

* **기능 (Methods)**
  * 생성자(이름, 고객번호) 
  * Getter/Setter 메서드
  * `toString()`: 고객 정보를 쉽게 출력하기 위해 재정의합니다.
  * `addAccount(Account account)`: 고객의 계좌 목록에 새로운 계좌를 추가힙니다.

---

#### 3-2. `Account` 클래스 (추상 클래스)

계좌번호 자동 발급, 공통 로직(입금, 출금)을 정의합니다.

* **속성 (Fields)**
  * `owner`: 소유주 (Customer)
  * `accountNumber`: 계좌번호 (String), 
    * 계좌번호 포맷 000111-00-000000
      * 앞 6자리: 은행 코드 + 지역/지점 코드(임의생성)
      * 중간 2자리: 상품 타입 코드(예: 01=입출금, 02=예금)
      * 마지막 6자리: 순번(자동 증가)
  * `balance`: 잔액 (double)

* **기능 (Methods)**
  * 생성자(소유주)
  * Getter 메서드
  * `toString()`: 계좌 정보를 쉽게 출력하기 위해 재정의합니다.
  * `deposit(double amount)`: 금액을 받아 입금 처리합니다.
  * `withdraw(double amount)`: 금액을 받아 출금 처리합니다. (잔액 부족 시 예외 발생)

* **하위 클래스 (구체화)**
  * `CheckingAccount`: 자유로운 입출금 계좌 
  * `SavingsAccount`: 예금 계좌

---

#### 3-3. `Bank` 클래스
실질적인 은행 기능을 수행하는 클래스입니다.

* **속성 (Fields)**
  * `customers`: 고객 정보를 저장할 Map<Integer, Customer>
  * `accounts`: 계좌 정보를 저장할 Map<String, Account>
  * `nextCustomerId`: 새로운 고객이 추가될 때마다 1씩 증가하는 고유 ID (int)
  * `nextAccountSeq`: 계좌번호 발급 시 사용하는 일련번호 (int)

* **기능 (Methods)**
  * `addCustomer(String name)`: 고객을 등록하고 `customers`에 추가합니다.
  * `createAccount(int customerId, String accountType)`: 특정 고객에게 계좌를 생성하고 `accounts`에 등록합니다 (계좌번호 자동 발급)
  * `listAllCustomers()`: 등록된 모든 고객 정보를 출력합니다.
  * `listAccountsByCustomer(int customerId)`: 특정 고객의 보유 계좌 목록을 출력합니다.
  * `searchAccount(String accountNumber)`: 계좌번호로 계좌를 조회합니다.
  * `deleteAccount(String accountNumber)`: 계좌번호로 계좌를 삭제합니다. 해당 고객의 계좌 목록 `List<Account>`에서도 계좌를 삭제합니다.
  * `deposit(String accountNumber, double amount)`: 입금 처리를 합니다.
  * `withdraw(String accountNumber, double amount)`: 출금 처리를 합니다.
  * `transfer(String fromAccount, String toAccount, double amount)`: 계좌 간 송금 처리를 합니다.

* **예외처리 (Exception)**
  * 입금, 출금, 송금 시 금액 유효성 검증 (0 이하 입력 차단)
  * 고객 ID나 계좌번호가 없는 경우 null 체크 처리

---

#### 3-4. `Main` 클래스
프로그램의 시작점이며,  콘솔 UI를 담당합니다.

* **기능 (Methods)**
  * `printMenu()`: 콘솔 메뉴를 출력합니다.
  * `handleUserInput()`: 사용자 입력에 따라 `Bank` 기능을 호출합니다.

---

### 4. 테스트 시나리오
* (1) 고객 등록 후 계좌 개설
* (2) 입금, 출금, 송금
* (3) 계좌 삭제
* (4) 전체 계좌 조회

---
### 5. 확장 아이디어
* 입력 검증 강화: 음수/0원 입금·출금 방지, 숫자 외 입력 시 재입력 유도.
* 계좌 검색 옵션: 계좌번호 정확 일치 + 고객명 부분 검색 둘 다 제공.
* 정렬 옵션 추가: 계좌 목록을 잔액↑/잔액↓/계좌번호 기준으로 정렬 선택.
* 간단한 통계: 은행 전체 총잔액, 평균잔액, 최고잔액/최저잔액 출력.
* 닉네임 필드: 계좌에 별칭(예: “비상금통장”) 추가/수정/조회.