package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService {
	
	
	//create 
	CategoryDto createCategroy(CategoryDto categoryDto);
	//update
	
	CategoryDto updateCategoryDto(CategoryDto categoryDto,Integer categoryId);
	
	//Delete
	
	void deleteCategory(Integer categoryId);
	
	//GetAll
	List<CategoryDto> getAllCategoryDto();
	
	//GetSingle Category
	
	CategoryDto getCategory(Integer categroyId);
	

}
