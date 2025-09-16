package com.likeliom.demo.repository;

import com.likeliom.demo.dto.ProductDTO;
import lion.jdbc.dept.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public ProductDTO getProductById(int id) {ProductDTO product = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from products where id = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            // 실행
            rs = ps.executeQuery();
            if(rs.next()) {
                product = new ProductDTO(); // 가방 생성
                product.setId(rs.getInt("id"));
                product.setNsme(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return null;
    }

    @Override
    public int insertProductAndGetId(ProductDTO product) {
        return 0;
    }
}
