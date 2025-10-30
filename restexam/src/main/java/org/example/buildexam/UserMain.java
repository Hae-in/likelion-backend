package org.example.buildexam;

public class UserMain {
    public static void main(String[] args) {
        // User 생성
        // 생성자를 통해서 객체를 생성할 때 순서나 어떤 값이 들어갈지 헷갈릴수 있다.
        // User user = new User("goldbb", 10, "서울", "goldbb@gmail.com");

        // User룰 생성하는데 이름과 나이만 가지고 생성하고 싶다면?
        // User룰 생성하는데 이름과 이메일만 가지고 생성하고 싶다면?
        // User룰 생성하는데 이름과 주소만 가지고 생성하고 싶다면?
        // User룰 생성하는데 이름, 주소, 이메일만 가지고 생성하고 싶다면?
        // => 모든 생성자가 정의되어있어야한다.

        User user1 = new User.Builder().address("대구").name("goldbb").age(3).build(); // 순서 상관 x
        System.out.println(user1);

        User user2 = new User.Builder().name("kim").build();
        System.out.println(user2);
    }
}
