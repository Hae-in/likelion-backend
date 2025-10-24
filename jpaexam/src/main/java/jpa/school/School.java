package jpa.school;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "school", // 관계의 주인을 지정 (반대편 @ManyToOne이 주인), 상대 엔티티의 필드명
            cascade = CascadeType.ALL, // 학교가 사라졌을때 같이 사라질지 설정, 부모 엔티티의 영속성 전이 옵션. (부모가 수행한 작업을 자식에게 전파)
            orphanRemoval = true, // 부모 엔티티에서 자식 객체를 컬렉션에서 제거했을 때 DB에서도 삭제할지 여부
            // fetch = FetchType.LAZY, // 실제로 접근할 때 쿼리 실행 (지연 로딩, 기본값)
            fetch = FetchType.EAGER) // 연관된 엔티티를 불러오는 시점(즉시/지연)을 결정, 부모 로드 시 자식도 즉시 함께 조회
    private List<Student> students = new ArrayList<>();
}
