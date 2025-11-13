# 미니프로젝트 : REST API 개발 - 회원/게시판/댓글 시스템

---

## 1. 프로젝트 개요
### 1-1. 프로젝트 설명
회원 관리, 게시판, 댓글 기능을 포함한 REST API 기반 게시판 시스템을 개발합니다. Spring Data JPA를 사용하여 데이터베이스를 관리하고, Spring Security를 통해 인증 및 권한을 처리합니다.

### 1-2. 핵심 기능
- 회원가입 및 로그인 (Spring Security 기반)
- 게시글 CRUD (생성, 조회, 수정, 삭제)
- 댓글 CRUD (평면 구조의 간단한 댓글)
- 페이징 처리
- 권한 관리 (본인 작성 글/댓글만 수정/삭제 가능)

### 1-3. 기술 스택
- Spring Boot 3.x 
- Spring Data JPA 
- Spring Security 6.x 
- MySQL 8.x 
- Lombok

---

## 2. 기능 요구사항 명세
### 📌 회원 관리 (User Management)
1. 회원 가입
- 중복된 loginId는 등록 불가
- 비밀번호는 BCrypt로 암호화하여 저장 
- 회원 가입 시 자동으로 "USER" 역할 부여 
- 회원 가입 API는 인증 없이 접근 가능

2. 회원 삭제
- 인증된 사용자만 접근 가능
- 본인 계정 또는 ADMIN 역할만 삭제 가능 (선택사항)

---

# API 테스트 가이드
## 4-1. 회원 API 테스트
### 테스트 시나리오 1: 회원 가입 (성공)
HTTP Request:
```http request
POST /users HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "김철수",
  "loginId": "chulsoo",
  "password": "password123!",
  "email": "chulsoo@example.com"
}
```

예상 응답 (201 Created):
```http request
{
  "id": 1,
  "name": "김철수",
  "loginId": "chulsoo",
  "email": "chulsoo@example.com",
  "joinedDate": "2025-01-15T10:30:00",
  "roles": [
    {
      "id": 1,
      "name": "USER"
    }
  ]
}
```

검증 포인트
- [x] 응답 코드가 201 Created인지 확인
- [x] password는 응답에 포함되지 않아야 함
- [x] roles에 자동으로 "USER" 역할이 부여되었는지 확인
- [x] 데이터베이스에 비밀번호가 암호화되어 저장되었는지 확인

---

### 테스트 시나리오 2: 중복 로그인 ID로 회원 가입 시도 (실패)
HTTP Request:
```http request
POST /users HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "이영희",
  "loginId": "chulsoo",
  "password": "password123!",
  "email": "younghee@example.com"
}
```
예상 응답 (409 Conflict):
```http request
{
  "timestamp": "2025-01-15T10:35:00",
  "status": 409,
  "error": "Conflict",
  "message": "이미 존재하는 로그인 ID입니다.",
  "path": "/users"
}
```

검증 포인트
- [x] 응답 코드가 409 Conflict인지 확인
- [x] "이미 존재하는 로그인 ID입니다." 메세지가 출력 되었는지 확인
- [x] 데이터베이스에 저장되지 않았는지 확인