package com.douglas.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.bookstore.domain.Category;
import com.douglas.bookstore.dtos.CategoryDTO;
import com.douglas.bookstore.repositories.CategoryRepository;
import com.douglas.bookstore.service.exceptions.DataIntegrityViolationException;
import com.douglas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Type: " + Category.class.getName()));
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category create(Category obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Category update(Integer id, CategoryDTO objDTO) {
		Category obj = findById(id);
		obj.setName(objDTO.getName());
		obj.setDescription(objDTO.getDescription());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada! Há livros associados a ela!");
		}
	}
}
