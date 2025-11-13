package org.miniproject.restboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.miniproject.restboard.domain.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String loginId;
    private String name;
    private String email;
    private LocalDateTime joinDate;
    private String role;

    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getLoginId(),
                user.getEmail(),
                user.getJoinedDate(),
                user.getRole().getName()
        );
    }
}
