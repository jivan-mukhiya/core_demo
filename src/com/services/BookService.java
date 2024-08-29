package com.services;

import com.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    void deleteBook(String isbn);
    List<Book> getAllBooks() ;
    void updateBook(Book book,String ISBN);

}
