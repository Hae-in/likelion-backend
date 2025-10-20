package com.example.springjdbc.jdbc01;

import java.util.List;

public interface UserDao {
    void insert(User user);
    List<User> findAllUsers();
}
