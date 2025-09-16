package com.likeliom.demo.service;

import com.likeliom.demo.dto.ProductDTO;
import com.likeliom.demo.repository.ProductDAO;
import com.likeliom.demo.repository.ProductDAOImpl;

public class ProductTest {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        boolean resultFlag = productDAO.insertProduct(new ProductDTO("book", 20000));
        System.out.println(resultFlag);

        // 게시글 저장
        //      1. 게시글 테이블에 글을 저장
        //      2. 첨부된 이미지 저장 (게시글이 저장되면서 생성된 id 필요) -> 에러 발생하면 롤백

        // int id = productDAO.insertProductAndGetId(new ProductDTO("appple", 120000));
        // System.out.println("apple 이 저장되면서 자동 생성된 id: " + id);

        // 하나의 서비스(기능)이 실행될 때 DAO가 여러번 호출 될 수 있음!
        // 커밋, 롤백 같이 이해해보세요.

        ProductDTO product = productDAO.getProductById(5);
        System.out.println(product);


    }
}
