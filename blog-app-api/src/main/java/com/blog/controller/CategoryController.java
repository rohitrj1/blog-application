package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategroy = this.categoryService.createCategroy(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategroy,HttpStatus.CREATED);
	}
	
	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategorydto(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		CategoryDto updateCategoryDto = this.categoryService.updateCategoryDto(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updateCategoryDto,HttpStatus.OK);
	}
	
	// Delete
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteCategorydto(@PathVariable Integer categoryId){
			 this.categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("category Id deleted successfully !!",true),HttpStatus.OK);
		}
		
		//get
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
			CategoryDto category = this.categoryService.getCategory(categoryId);
			return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
		}
		
		//get All
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategory(){
			List<CategoryDto> allCategoryDto = this.categoryService.getAllCategoryDto();
			return  ResponseEntity.ok(allCategoryDto);
		}


}
