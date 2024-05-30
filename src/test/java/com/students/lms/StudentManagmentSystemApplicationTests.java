package com.students.lms;

import com.students.lms.dto.BookDto;
import com.students.lms.dto.ReportDto;
import com.students.lms.dto.UserDto;
import com.students.lms.entity.Report;
import com.students.lms.entity.Role;
import com.students.lms.entity.User;
import com.students.lms.repository.BookRepository;
import com.students.lms.repository.UserRepository;
import com.students.lms.service.BookService;
import com.students.lms.service.ReportService;
import com.students.lms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentManagmentSystemApplicationTests {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private ReportService reportService;

	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
		UserDto user = userService.findUserByEmail("g@gmail.com");
		List<Role> roles = user.getRoles();
		for (Role role : roles){
			System.out.println(role.getName());
		}


	}

}
