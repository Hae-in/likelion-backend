package com.example.springjdbc.friendapp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter // getter, setter가 없으면? 프레임워크가 내부적으로 사용할 값을 set, get 불가능
@NoArgsConstructor
@AllArgsConstructor
@ToString
// @EqualsAndHashCode
public class Friend { // 테이블명과 엔티티 클래스명이 같으면 @Table 생략 가능
    @Id
    private Long id;
    private String name;
    private String email;
}
