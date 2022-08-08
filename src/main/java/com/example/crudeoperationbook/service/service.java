package com.example.crudeoperationbook.service;

import com.example.crudeoperationbook.model.books;

import java.util.List;

public interface service {


    books saveBook(books book);

    List<books> getAllBook();
    books getBookById(int id);
    books updateBook(books book,int id);
    void deleteBook(int id);
}


