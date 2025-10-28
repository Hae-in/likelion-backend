package org.example.springdatajpa3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCustomRepository {
    void lionCustome();
    List<User> findByUserName(String name);

    // 조회: 이름, 내용, 날짜
    // 방법1. 서비스 - if(kind == 이름) repository.findByName()
    // 방법2. repository 쪽에서 kind에 따라서 쿼리가 바뀜
    List<User> findUserDynamically(String name, String email);

}
