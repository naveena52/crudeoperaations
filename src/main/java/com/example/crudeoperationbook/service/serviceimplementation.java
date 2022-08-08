package com.example.crudeoperationbook.service;

import com.example.crudeoperationbook.model.books;
import com.example.crudeoperationbook.repository.booksrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceimplementation implements service
{
    @Autowired
    private booksrepo booksRepo;

    public serviceimplementation
            (booksrepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    @Override
    public books saveBook(books book)
    {
        return booksRepo.save(book);
    }
    @Override
    public List<books> getAllBook()
    {

        return (List<books>) booksRepo.findAll();
    }
    @Override

    public books getBookById(int id)
    {
        return booksRepo.findById(id).orElseThrow();
    }
    @Override
    public books updateBook(books book,int id)
    {
        books existingBook=booksRepo.findById(id).orElseThrow();

        existingBook.setBookname(book.getBookname());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        booksRepo.save(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(int id) {
        booksRepo.findById(id).orElseThrow();
        booksRepo.deleteById(id);
    }

}

