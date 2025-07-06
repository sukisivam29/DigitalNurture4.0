package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring container from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get bean and test
        BookService service = context.getBean("bookService", BookService.class);
        service.addBook("The Alchemist");
        service.listBooks();
    }
}
