package com.services;

import com.db.DbConnection;
import com.model.Product;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductServices{

    @Override
    public void addProduct(Product p) {
        String sql="insert into product(name,price,company,mdfDate,expDate) values(?,?,?,?,?)";

        try{
            PreparedStatement pstmt= DbConnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,p.getName());
            pstmt.setInt(2,p.getPrice());
            pstmt.setString(3,p.getCompany());
            pstmt.setDate(4, Date.valueOf(p.getMdfDate()));
            pstmt.setDate(5, Date.valueOf(p.getExpDate()));

            pstmt.executeUpdate();
            System.out.println("Product added successfully");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(int  id) {

        String sql="delete from product where id=?";

        try {
            PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Product deleted success !!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> getAllProducts() {

        String sql="select * from product";
        List<Product> productList=new ArrayList<>();

        try {
            Statement statement = DbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setCompany(resultSet.getString("company"));
                product.setExpDate(resultSet.getDate("mfdDate").toLocalDate());
                product.setExpDate(resultSet.getDate("expDate").toLocalDate());
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void updateProduct(Product p,int id) {
        String sql ="Update product SET name=?,price=?,company=?,mfdDate=?,expDate=? Where id=?";
        try{
            PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,p.getName());
            preparedStatement.setInt(2,p.getPrice());
            preparedStatement.setString(3,p.getCompany());
            preparedStatement.setDate(4, Date.valueOf(p.getMdfDate()));
            preparedStatement.setDate(5, Date.valueOf(p.getExpDate()));
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
            System.out.println("Product updated successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
