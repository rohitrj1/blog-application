package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto,Integer usrId,Integer categoryId);
	
	
	// update
	
	PostDto updatePost(PostDto postDto ,Integer postId);
	
	// getAll
	
	PostResponse getAllPost(Integer pageNo , Integer pageSize,String sort,String sortDir);
	
	//getSingle
	
	PostDto getSinglePost(Integer postId);
	
	//delete
	
	void deletePostDto(Integer postId);
	
	//getAll post by User
	List<PostDto> getAllPostByUser(Integer userId);

	
	//getAll post by Category
	List<PostDto> getAllPostByCategory(Integer categoryId);
	
	//getAll post by search
	List<PostDto> serachPost(String keyword);
	
	
}
