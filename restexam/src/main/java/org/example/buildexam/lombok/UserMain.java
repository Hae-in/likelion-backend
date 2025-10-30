package org.example.buildexam.lombok;

public class UserMain {
    public static void main(String[] args) {
        User user1 = User.builder().name("goldbb").email("goldbb@gmail.com").build();
        System.out.println(user1);
    }
}
