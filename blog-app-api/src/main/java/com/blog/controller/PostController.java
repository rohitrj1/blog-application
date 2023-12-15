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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.config.AppConstants;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// create a post 
	
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto ,@PathVariable Integer userId,@PathVariable Integer categoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	// getByUser
	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getUserPost(@PathVariable Integer userId){
		List<PostDto> allPostByUser = this.postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(allPostByUser,HttpStatus.OK);
	}
	
	//getBycategory
	
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDto>> getCategoryPost(@PathVariable Integer categoryId){
		List<PostDto> allPostByCategory = this.postService.getAllPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(allPostByCategory,HttpStatus.OK);
	}
	
	// get All Post
	
	@GetMapping("/post")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sort,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir){
		PostResponse allPost = this.postService.getAllPost(pageNumber,pageSize,sort,sortDir);
		return new ResponseEntity<PostResponse>(allPost,HttpStatus.OK);
	}
	
	//get single post
	@GetMapping("post/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId) {
		PostDto singlePost = this.postService.getSinglePost(postId);
		return new ResponseEntity<PostDto>(singlePost,HttpStatus.OK);
	}
	
	// delete post
	
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
		this.postService.deletePostDto(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("post Id deleted successfully !!",true),HttpStatus.OK);
	}
	
	
	//update post
	
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
	}
	
	// search 
	
	@GetMapping("/post/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTittle(@PathVariable String keywords){
		List<PostDto> searchPost = this.postService.serachPost(keywords);
		return new ResponseEntity<List<PostDto>>(searchPost,HttpStatus.OK);
	}
	

}
