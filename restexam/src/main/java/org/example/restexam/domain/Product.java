package org.example.restexam.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.restexam.dto.ProductDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;
    private int price;

    // DTO --> Entity 로 변환하는 메서드
    public static Product fromDto(ProductDTO dto) {
        return Product.builder().id(dto.getId()).name(dto.getName()).price(dto.getPrice()).build();
    }
}
