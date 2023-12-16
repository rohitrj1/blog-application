package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	

	private Integer postId;
	
	private String title;
	
	@Column(name ="content" ,length = 1000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comment =new HashSet<>();
}
