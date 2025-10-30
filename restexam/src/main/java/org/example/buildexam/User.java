package org.example.buildexam;

import lombok.ToString;

@ToString
public class User {
    private String name;
    private int age;
    private String email;
    private String address;

    // private 생성자이므로 빌더만 접근이 가능하게 설계함
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
    }

    // static한 내부 클래스 Builder
    public static class Builder {
        private String name;
        private int age;
        private String email;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this); // this: private User(Builder builder)
        }
    }
}
