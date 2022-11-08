package com.douglas.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.repositories.CategoryRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public void databaseSeeding() {
		Category cat1 = new Category(null, "Computers", "IT books");
		Category cat2 = new Category(null, "Science fiction", "Scifi books");
		Category cat3 = new Category(null, "Bibliography", "Bibliography books");

		Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Book b2 = new Book(null, "Software engineearing", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Book b3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Book b4 = new Book(null, "The war of the worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Book b5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		cat2.getBooks().addAll(Arrays.asList(b3, b4, b5));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}
}