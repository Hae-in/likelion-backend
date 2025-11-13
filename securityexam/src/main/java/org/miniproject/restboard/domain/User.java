package org.miniproject.restboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "login_id", unique = true, nullable = false, length = 100)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "joined_date", nullable = false, updatable = false)
    private LocalDateTime joinedDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER) // EAGER: role이 채워질때 같이 채워짐
    @JoinColumn(name = "role_id")
    private Role role;
}
