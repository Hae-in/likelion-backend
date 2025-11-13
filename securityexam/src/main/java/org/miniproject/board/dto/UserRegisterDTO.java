package org.miniproject.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRegisterDTO {
    private String loginId;
    private String password;
    private String name;
    private String email;

    private List<String> roles; // html 
}
