package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // ✅ Required for Dependency Injection (setter-based)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String name) {
        bookRepository.add(name);
    }

    public void listBooks() {
        List<String> books = bookRepository.getAll();
        books.forEach(System.out::println);
    }
}
