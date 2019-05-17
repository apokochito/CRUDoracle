package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private JpaProducts jpaProducts;


    @Autowired
    public ProductRepositoryImpl(JpaProducts jpaProducts) {
        this.jpaProducts = jpaProducts;
    }

    @Override
    public List<ProductEntity> getProducts() {
        List<ProductEntity> response = jpaProducts.findAll();
        return response;
    }

    @Override
    public ProductEntity getProductById(long id) {
        ProductEntity response = jpaProducts.findById(id).get();
        return response;
    }

    @Override
    public ProductEntity getProductByName(String name) {
        ProductEntity productEntity = new ProductEntity();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String FIND_PRODUCT_BY_NAME = "SELECT * FROM PRODUCTS WHERE name ='" + name + "'";

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
            Statement sentence = conn.createStatement();
            ResultSet rs = sentence.executeQuery(FIND_PRODUCT_BY_NAME);
            while (rs.next()) {
                productEntity.setId(rs.getLong("ID"));
                productEntity.setName(rs.getString("NAME"));
                productEntity.setBrand(rs.getString("BRAND"));
                productEntity.setQuantity(rs.getInt("QUANTITY"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //System.err.println("Red alert!");
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return productEntity;
    }
}
