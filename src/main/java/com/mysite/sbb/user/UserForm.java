package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
	@Size(min = 3, max = 15)
	@NotEmpty(message = "아이디가 비어있습니다.")
	private String username;
	
	@NotEmpty(message = "비밀번호가 비어있습니다.")
	private String password;
	private String passwordCheck;
	
	@Email
	@NotEmpty(message = "이메일이 비어있습니다.")
	private String email;
}
