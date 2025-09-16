package com.likeliom.demo.service;

import com.likeliom.demo.dto.ProductDTO;
import com.likeliom.demo.repository.ProductDAO;
import com.likeliom.demo.repository.ProductDAOImpl;

public class ProductTest {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        boolean resultFlag = productDAO.insertProduct(new ProductDTO("book", 20000));
        System.out.println(resultFlag);
    }
}
