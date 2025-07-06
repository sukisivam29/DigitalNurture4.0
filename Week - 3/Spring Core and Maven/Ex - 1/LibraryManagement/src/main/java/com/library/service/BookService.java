package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;        // Setter‑injection by Spring

    // Spring calls this setter; must be public
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Convenience API
    public void addBook(String title) {
        bookRepository.add(title);
    }

    public List<String> listBooks() {
        return bookRepository.findAll();
    }
}
