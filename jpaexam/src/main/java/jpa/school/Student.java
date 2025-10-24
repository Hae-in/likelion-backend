package jpa.school;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // 내가 기준, 학생 n:학교 1
    @JoinColumn(name = "school_id")
    private School school; // 연관 관계를 알려줄 필요가 있다.

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }
}
