package com.douglas.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.repositories.BookRepository;
import com.douglas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Book findById(Integer id) {
		Optional<Book> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id:" + id + ", Type:" + BookService.class.getName()));
	}

	public List<Book> findAll(Integer id_cat) {
		categoryService.findById(id_cat);
		return repository.findAllByCategory(id_cat);
	}
}
