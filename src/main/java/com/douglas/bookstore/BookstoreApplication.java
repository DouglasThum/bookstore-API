package com.douglas.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática", "Livro de TI");
		
		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getBooks().addAll(Arrays.asList(b1));
		
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(b1));
	}

}
