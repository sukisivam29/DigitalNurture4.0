package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // You get built-in CRUD methods like save(), findAll(), deleteById(), etc.
}
