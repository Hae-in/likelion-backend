package com.likeliom.demo.repository;

import com.likeliom.demo.dto.ProductDTO;
import lion.jdbc.dept.DBUtil;

import java.sql.*;
import java.util.ArrayList;
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
        List<ProductDTO> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from products";

        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();

            while(rs.next()){
                products.add(resultSetToProductDTO(rs));  // 깔끔 ⭐️
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            DBUtil.close(conn,ps,rs);
        }



        return products;
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
                product = resultSetToProductDTO(rs); // 깔끔 ⭐️
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return product;
    }

    @Override
    public int insertProductAndGetId(ProductDTO product) {
        int id = 0;
        String sql = "insert into products(name, price, reg_date) values(?,?,now())";

        try(
                // 접속
                Connection conn = DBUtil.getConnection();
                // 쿼리 작성
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, product.getNsme());
            ps.setInt(2, product.getPrice());

            // 실행
            int count = ps.executeUpdate(); // 실행 후, GeneratedKey 생성
            if(count > 0) {
                ResultSet rs = ps.getGeneratedKeys(); // GeneratedKey return
                if(rs.next()) {
                    id = rs.getInt(1);
                }
            } else {
                System.out.println("상품 등록에 실패했습니다.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    // product.setId(rs.getInt("id")); 중복, 반복 줄이기
    // select 할 때, ResultSet에서 값을 꺼내서 DTO에 담는 작업을 한건 조회할때도, 여러건 조회할때도 계속 사용 되고있다.
    // 상품명으로 조회, 등등 메서드가 더 추가된다면??
    // 접근제한자: 여기에서만 사용 - private
    // return: ProductDTO
    private ProductDTO resultSetToProductDTO(ResultSet rs) throws SQLException {
        ProductDTO product = new ProductDTO(); // 가방 만들기

        product.setId(rs.getInt("id"));
        product.setNsme(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        // product.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());

        // null 값 처리, null일 경우 null로 처리, null 아닌 경우 변환해서 출력
        Timestamp regDate = rs.getTimestamp("reg_date");
        if(regDate != null) {
            product.setRegDate(regDate.toLocalDateTime());
        }

        return product;
    }
}
