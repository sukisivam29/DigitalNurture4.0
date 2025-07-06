package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. Load Spring context from our XML file
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Ask Spring for the BookService bean
        BookService service = context.getBean("bookService", BookService.class);

        // 3. Use the service
        service.addBook("The Pragmatic Programmer");
        service.addBook("Clean Code");

        System.out.println("Books in library:");
        service.listBooks().forEach(System.out::println);
    }
}
