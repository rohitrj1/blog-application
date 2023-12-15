package com.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.repository.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategroyServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategroy(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategoryDto(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCategory = this.categoryRepo.save(cat);
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
	
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", " categoryId", categoryId));
		this.categoryRepo.delete(category);
		
	}

	@Override
	public List<CategoryDto> getAllCategoryDto() {
		List<Category> lstCategory = this.categoryRepo.findAll();
		List<CategoryDto> categoryDto = lstCategory.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category categor = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Catgeory", "categoryId",categoryId));
		
		return this.modelMapper.map(categor, CategoryDto.class);
	}

}
