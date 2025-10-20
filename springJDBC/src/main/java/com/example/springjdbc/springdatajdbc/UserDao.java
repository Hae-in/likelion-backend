package com.example.springjdbc.springdatajdbc;

import java.util.Optional;

public interface UserDao {
    Optional<User> abcUser(String email);
}
