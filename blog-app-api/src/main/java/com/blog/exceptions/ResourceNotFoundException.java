package com.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldsValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldsValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldsValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldsValue = fieldsValue;
	}
	
	
	

}
