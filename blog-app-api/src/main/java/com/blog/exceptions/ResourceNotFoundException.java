package com.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldsValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldsValue) {
		super(String.format("%s not found with %s : %l",resourceName,fieldName,fieldsValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldsValue = fieldsValue;
	}
	
	
	

}
