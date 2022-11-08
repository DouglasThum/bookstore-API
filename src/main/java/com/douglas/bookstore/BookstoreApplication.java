package com.douglas.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
