package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // ✅ Setter for Spring's Setter-based DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String name) {
        bookRepository.save(name);
    }

    public void listBooks() {
        System.out.println("Listing all books...");
    }
}
