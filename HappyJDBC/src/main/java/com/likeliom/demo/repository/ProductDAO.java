package com.likeliom.demo.repository;

import com.likeliom.demo.dto.ProductDTO;

import java.util.List;

public interface ProductDAO {
    public boolean insertProduct(ProductDTO product);
    public boolean updateProduct(ProductDTO product);
    public boolean deleteProduct(ProductDTO product);
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(int id);

    // 입력이 될때 아이디가 자동으로 입력.

    // 트랜잭션
    //     게시글 테이블: id, 제목, 내용, user, 날짜, 사진 3장
    //     사진 테이블: 파일명, 경로
    // 게시글이 저장되면 자동으로 생성된 id 값을 얻어와야 다음 사진의 정보를 저장할때 해당 게시글id를 저장할 수 있다.
    public int insertProductAndGetId(ProductDTO product);
}
