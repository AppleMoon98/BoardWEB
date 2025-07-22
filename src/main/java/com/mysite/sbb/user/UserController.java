package com.mysite.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {
	private final UserService userService;
	
	@GetMapping("/signup")
	@PreAuthorize("isAnonymous()")
	public String signup(UserForm userForm) {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserForm userForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "signup_form";
		
		if(!userForm.getPassword().equals(userForm.getPasswordCheck())) {
			bindingResult.rejectValue("passwordCheck", "passwordincorrect", "비밀번호가 서로 다릅니다.");
			return "signup_form";
		}
		
		try {
			this.userService.create(userForm.getUsername(), userForm.getEmail(), userForm.getPassword());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 아이디 혹은 이메일 입니다.");
			return "signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			return "signup_form";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}

}
