package com.mysite.sbb;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

@SpringBootTest
class BoardWebApplicationTests {
	@Autowired
	private QuestionService qService;

	@Autowired
	private UserService userService;
	

	@Test
	void contextLoads() {
		userService.create("1");
	}

}
