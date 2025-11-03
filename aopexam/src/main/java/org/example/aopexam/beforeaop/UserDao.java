package org.example.aopexam.beforeaop;

public class UserDao {
    // user를 하나 추가
    public void addUser() {
        // 로그 남기기
        System.out.println("로그를 남깁니다.");

        // 트랜잭션 처리
        System.out.println("트랜잭션을 처리합니다.");

        System.out.println("User를 추가하는 코드1");
        System.out.println("User를 추가하는 코드2");
        System.out.println("User를 추가하는 코드3");
        System.out.println("User를 추가하는 코드4");

        // 트랜잭션 처리
        System.out.println("트랜잭션을 처리합니다.");
    }

    public void updateUser() {
        System.out.println("user를 수정하는 코드1");
        System.out.println("user를 수정하는 코드2");
        System.out.println("user를 수정하는 코드3");
        System.out.println("user를 수정하는 코드4");
    }
}
