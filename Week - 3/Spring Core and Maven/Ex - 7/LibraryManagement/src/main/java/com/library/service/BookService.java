package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String serviceName;

    // ✅ Constructor for constructor-based injection
    public BookService(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Constructor Injection: serviceName = " + serviceName);
    }

    // ✅ Setter for setter-based injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection: BookRepository injected");
    }

    public void addBook(String name) {
        bookRepository.save(name);
    }

    public void listBooks() {
        System.out.println("Service name: " + serviceName);
        System.out.println("Listing all books...");
    }
}
