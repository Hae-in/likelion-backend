# Java

### 05. 변수와 기본 타입

- 변수와 리터럴의 개념과 차이점
- 기본 타입 8가지의 특징과 범위
- 연산자를 사용하여 다양한 연산을 수행
- 타입 변환 규칙을 이해하고 적절히 적용
- 식별자 규칙과 네이밍 컨벤션을 준수

---

1. 변수와 리터럴

- 변수(Variable): 값을 저장하는 `메모리 공간에 붙인 이름`(식별자)
- 리터럴(Literal): `소스코드`에 직접 적어 넣은 `값 자체`
    - ex) 1, 100, 0b1010, 'A', "Hello", true, 3.14f

---

2. 변수 선언 방법

- `타입 변수명 대입연산자 리터럴;`
- ex) int i = 1;
    - int: 정수 타입(4byte)을 나타내는 키워드(예약어)
    - i: 변수명(식별자), `메모리 공간의 이름`
    - =: 대입연산자
    - 1: 정수 리터럴

---

3. 기본 타입

- 정수 타입

<table>
    <tr>
        <td align="center">타입</td>
        <td align="center">크기</td>
        <td align="center">범위</td>
        <td align="center">기본값</td>
    </tr>
    <tr>
        <td >byte</td>
        <td>1 byte</td>
        <td>-128 ~ 127</td>
        <td>0</td>
    </tr>
    <tr>
        <td>shor</td>
        <td>2 byte</td>
        <td>132,768 ~ 32,767</td>
        <td>0</td>
    </tr>
    <tr>
        <td>int</td>
        <td>4 byte</td>
        <td>-2,147,483,648 ~ 2,147,483,647</td>
        <td>0</td>
    </tr>
    <tr>
        <td>long</td>
        <td>8 byte</td>
        <td>-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807</td>
        <td>0L</td>
    </tr>
</table>

- 실수 타입

<table>
    <tr>
        <td align="center">타입</td>
        <td align="center">크기</td>
        <td align="center">범위</td>
        <td align="center">기본값</td>
    </tr>
    <tr>
        <td>float</td>
        <td>4 byte</td>
        <td>±1.4E-45 ~ ±3.4E38 (7자리 정밀도)</td>
        <td>0.0f</td>
    </tr>
    <tr>
        <td>double</td>
        <td>8 byte</td>
        <td>±4.9E-324 ~ ±1.8E308 (15자리 정밀도)</td>
        <td>0.0</td>
    </tr>
</table>

- 논리 타입

<table>
    <tr>
        <td align="center">타입</td>
        <td align="center">크기</td>
        <td align="center">범위</td>
        <td align="center">기본값</td>
    </tr>
    <tr>
        <td>boolean</td>
        <td>1 byte</td>
        <td>true / false</td>
        <td>false</td>
    </tr>
</table>

- 문자 타입

<table>
    <tr>
        <td align="center">타입</td>
        <td align="center">크기</td>
        <td align="center">범위</td>
        <td align="center">기본값</td>
    </tr>
    <tr>
        <td>char</td>
        <td>2 byte</td>
        <td>0 ~ 65,535 (유니코드)</td>
        <td>'\u0000'</td>
    </tr>
</table>

---

4. 타입 변환

- 작은 타입 -> 큰 타입: 자동 타입 변환 `묵시적`
- 큰 타입 -> 작은 타입: 강제 타입 변환 `명시작`
    ```java
  double d = 3.14;
  int i = d; // 3 (소수점 버림)
  byte b = (byte) 128; (오버플로우)
    ```

---

5. 산술 승격

- 자바에서는 `byte`, `short`, `char` 타입끼리 산술 연산을 할 때, 자동으로 `int`타입으로 변환된다.

    ```java
    byte a = 10;
    byte b = 20;
    byte result = a + b; // ❌ 컴파일 에러
    
    byte a = 10;
    byte b = 20;
    int result = a + b; // 30
  
    char ca = 'A'; // 65
    char cb = 'B'; // 66
    int result = ca + cb; //131
  
    int x = 5;
    int y = 2;
    int d1 = x / y; // 2
    double d1 = x / y; // 2.0
    double d1 = (double) x / y; // 2.5
    ```

---

### 6. 조건문
