package com.douglas.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Field TITLE can't be empty!")
	@Length(min=3, max=50, message = "Field TITLE must be between 3 and 50 characters")
	private String title;
	
	@NotEmpty(message = "Field AUTHOR can't be empty!")
	@Length(min=3, max=100, message = "Field AUTHIR must be between 3 and 100 characters")
	private String author;
	
	@NotEmpty(message = "Field TEXT can't be empty!")
	@Length(min=10, message = "Field TEXT must be bigger than 10 characters")
	private String text;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Book() {
		super();
	}

	public Book(Integer id, String title, String author, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.text = text;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
}
