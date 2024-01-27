package com.blog.payloads;




import java.util.HashSet;
import java.util.Set;

import com.blog.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4 ,message ="Username must be min of 4 characters")
	private String name;
	
	@Email(message = " Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 10 ,message = "password must be 3 chars and max of 10 chars !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
