package com.example.crudeoperationbook.repository;

import com.example.crudeoperationbook.model.books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface booksrepo extends JpaRepository<books,Integer>
{
    Optional<books> findByEmail(String email);
}



