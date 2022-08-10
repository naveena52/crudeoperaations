package com.example.crudeoperationbook.controller;

import com.example.crudeoperationbook.model.books;
import com.example.crudeoperationbook.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/books")
    public class bookControllers {
        @Autowired
        private service booksService;

        public bookControllers(service booksService) {
            this.booksService = booksService;
        }
        @PostMapping
        public ResponseEntity<books> saveBook(@RequestBody books book)
        {
            return new ResponseEntity<books>(booksService.saveBook(book), HttpStatus.CREATED);
        }
        @GetMapping
        public List<books> getAllBooks()
        {
            return booksService.getAllBook();
        }
        @GetMapping("{id}")
        public ResponseEntity<books> getBookById(@PathVariable("id")int id)
        {
            return new ResponseEntity<books>(booksService.getBookById(id), HttpStatus.OK);
        }
        @PutMapping("{id}")
        public ResponseEntity<books> updateBook(@PathVariable("id")int id,@RequestBody books book)
        {
            return new ResponseEntity<books>(booksService.updateBook(book,id), HttpStatus.OK);
        }
        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteBook(@PathVariable("id")int id)
        {
            booksService.deleteBook(id);
            return new ResponseEntity<String>("Book data deleted successfully",HttpStatus.OK);
        }
    }



