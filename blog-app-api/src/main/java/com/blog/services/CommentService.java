package com.blog.services;

import com.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto , Integer commentId);
	
	void deleteComment(Integer commentId);
	

}
