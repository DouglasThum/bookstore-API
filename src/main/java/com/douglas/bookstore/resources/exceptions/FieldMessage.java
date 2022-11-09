package com.douglas.bookstore.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;
	public FieldMessage() {
		super();
	}
	public FieldMessage(String filedName, String message) {
		super();
		this.fieldName = filedName;
		this.message = message;
	}
	public String getFiledName() {
		return fieldName;
	}
	public void setFiledName(String filedName) {
		this.fieldName = filedName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
