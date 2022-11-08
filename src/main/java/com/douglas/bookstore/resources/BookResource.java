package com.douglas.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.bookstore.domain.Book;
import com.douglas.bookstore.dtos.BookDTO;
import com.douglas.bookstore.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat) {
		List<Book> list = service.findAll(id_cat);
		List<BookDTO> listDto = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
