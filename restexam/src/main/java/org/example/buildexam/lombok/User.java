package org.example.buildexam.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User {
    private String name;
    @Builder.Default
    private int age = 10;
    private String email;
    private String address;
}
