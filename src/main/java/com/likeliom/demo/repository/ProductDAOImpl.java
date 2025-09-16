package com.likeliom.demo.repository;

import com.likeliom.demo.dto.ProductDTO;
import lion.jdbc.dept.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean insertProduct(ProductDTO product) {boolean result = false;

        String sql = "insert into products(name, price, reg_date) values(?,?, now())";

        try(
                // 접속
                Connection conn = DBUtil.getConnection();
                // 쿼리 작성
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, product.getNsme());
            ps.setInt(2, product.getPrice());

            // 실행
            int count = ps.executeUpdate();

            if(count > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
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
