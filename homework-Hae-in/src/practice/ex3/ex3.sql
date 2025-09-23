use hr;

-- 문자 함수를 이용한 SQL 연습 문제
-- 1. **직원의 성(last_name)을 대문자로 변환하여 조회하기**:
select upper(last_name) from employees;

-- 2. **직원의 이름(first_name)의 첫 글자를 추출하기**:
select first_name, substring(first_name, 1, 1) from employees;
select first_name, left(first_name, 1) from employees;

-- 3. **직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기**:
select last_name, (LENGTH(last_name) - LENGTH(REPLACE(LOWER(last_name), 'a', ''))) as a from employees;

-- 4. **직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열)**:
select substring_index('adadasdafa@naver.com', '@', -1);
select substring_index(email, '@', -1) from employees;

-- 5. **직원의 전체 이름을 성과 이름으로 구분하여 조회하기**:
select first_name, last_name, concat(first_name, ' ', last_name) as full_name from employees;

-- 6. **직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기**:
select first_name, substring(first_name, 3, 3) from employees;

-- 7. **모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기**:
select concat(last_name, ', ', first_name) from employees;

-- 8. **직원의 이름(first_name)의 길이를 구하여 조회하기**:
select first_name, length(first_name) from employees;

-- 9. **직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이)**:
select * from employees where last_name like 'King';
select * from employees where lower(last_name) ='king';

-- 10. **직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기**:~~~~
select count(*) from employees where last_name like 'M%';