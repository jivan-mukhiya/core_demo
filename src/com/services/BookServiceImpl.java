package com.services;

import com.db.DbConnection;
import com.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{

   // List<Book> books=new ArrayList<>();
    @Override
    public void addBook(Book book){
       String sql="insert into book values(?,?,?,?,?)";
       //books.add(book);
        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement((sql));
            preparedStatement.setString(1,book.getIsbn());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setString(4,book.getPublisher());
            preparedStatement.setDouble(5,book.getPrice());
            preparedStatement.executeUpdate();
            System.out.println("book added successfully !!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteBook(String isbn) {
        String sql="delete from book where isbn=?";

        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement((sql));
            preparedStatement.setString(1,isbn);
            preparedStatement.executeUpdate();
            System.out.println("book deleted successfully !!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql="select * from book";
        try{
            Statement statement=DbConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {
                books.add(new Book(resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("publisher"),
                        resultSet.getString("isbn"),
                        resultSet.getDouble("price")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void updateBook(Book book, String ISBN) {

        String sql ="Update book SET title=?,author=?,publisher=?,price=? Where isbn=?";

        try{
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getPublisher());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setString(5,ISBN);
            preparedStatement.executeUpdate();
            System.out.println("book updated successfully !!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
