package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Product;
import org.example.restexam.dto.ProductDTO;
import org.example.restexam.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /*
           |   프레젠테이션 레이어   |    서비스 레이어    |    데이터 레이어    |
           |    (Controller)    |    (Service)     |   (Repository)  |
           |                    |                  |                 |
           |                   DTO <----------> Entity <-> JPA       |
           |                    |                  |                 |
           |                    |                  |                 |
     */

    // 상품 추가
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        // DTO에 들어있는 값을 Entity로 옮겨 담는 일이 필요!!!
        // Product product = new Product();
        // product.setName(productDTO.getName());
        // product.setPrice(productDTO.getPrice());

        // Product product = new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice());
        // Product product = Product.builder().name(productDTO.getName()).price(productDTO.getPrice()).build();
        // 이렇게 채울수는 있으나....매 번 이런 일 해야할까요 ? ? ?

        // DTO에 들어있는 값을 Entity로 옮겨 담는 일이 필요
        Product product = Product.fromDto(productDTO);
        Product savedProduct = productRepository.save(product); // Repository에 매개변수로 전달 될 값은 엔티티 여야함

        return ProductDTO.fromEntity(savedProduct);
    }

    // 상품 조회 (전체상품)
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDTO::fromEntity).toList();
    }

    // 상품 조회 (특정상품)
    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found id = " + id)); // 엔티티로 가져온 값
        return ProductDTO.fromEntity(product);
    }

    // 상품정보 수정
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(() -> new RuntimeException("Product not found id = " + productDTO.getId()));

        // 수정
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }

        // Optional을 이용해서 위 코드를 아래처럼 사용할 수 있음
        // Optional.ofNullable(productDTO.getName()).ifPresent(product::setName);

        if (productDTO.getPrice() != 0) { // int(0) vs Integer(null)
            product.setPrice(productDTO.getPrice());
        }

        return ProductDTO.fromEntity(product);
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found id = " + id);
        }
        productRepository.deleteById(id);
    }
}
