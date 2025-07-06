package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ✅ Load Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // ✅ Get BookService bean (with BookRepository injected)
        BookService service = context.getBean("bookService", BookService.class);

        // ✅ Use the service
        service.addBook("Spring in Action");
        service.addBook("Effective Java");

        System.out.println("Books in the library:");
        service.listBooks();
    }
}
