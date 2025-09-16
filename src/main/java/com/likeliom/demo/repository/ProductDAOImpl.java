package com.likeliom.demo.repository;

import com.likeliom.demo.dto.ProductDTO;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean insertProduct(ProductDTO product) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductDTO product) {
        return false;
    }

    @Override
    public boolean deleteProduct(ProductDTO product) {
        return false;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(int id) {
        return null;
    }

    @Override
    public int insertProductAndGetId(ProductDTO product) {
        return 0;
    }
}
