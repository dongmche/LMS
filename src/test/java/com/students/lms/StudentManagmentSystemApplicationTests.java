package com.students.lms;

import com.students.lms.dto.ReportDto;
import com.students.lms.entity.Report;
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
//		User user = userRepository.findByEmail("a@gmail.com");
//		UserDto user1 = userService.findUserByEmail("a@gmail.com");
//		User user = UserMapper.mapToUser(user1);
//		assert user != null;
//		assert Objects.equals(user.getEmail(), "a@gmail.com");
//		assert Objects.equals(user.getName(), "a a");
//		assert Objects.equals(user.getEmail(), "a@gmail.com");
//		assert 5 == 4;

//		String email = "a@gmail.com";
//		User user1 = userRepository.findByEmail("a@gmail.com");
//		User user = UserMapper.mapToUser(userService.findUserByEmail("a@gmail.com"));


//		assert 3 == user.getId();
//		userRepository.save(user);
//		User user = userRepository.findByEmail("a@gmail.com");
//		assert 3 == user.getId();
//		UserDto userDto = UserMapper.mapToUserDto(user);
//		assert 3 == userDto.getId();

//		UserDto userDto = userService.findUserByEmail(email);
//		System.out.println(userDto.getId());
//		User user = UserMapper.mapToUser(userDto);
//		System.out.println(user.getId());
//		List<UserDto> users = userService.findAllUser();
//		assert 1 == users.size();
//		for (UserDto user : users) {
//			System.out.println("User: " + user.getFirstName());
//			System.out.println("Books:");
//			for (Book book : user.getBooks()) {
//				System.out.println("- " + book.getTitle());
//			}
//		}			System.out.println(bookRepository.getBookIsb());

//		System.out.println(bookService.getBookIsbnById(1));
//		assert "f".equals(bookService.getBookIsbnById(1));
//
//		Report report = new Report();
//		report.setUserEmail("gio");
//		report.setUserEmail("as");
//		report.setReportStatus(ReportStatus.RETURNED);
//		reportService.report(report);

////		Book book = bookRepository.searchBook("faf");
//		System.out.println(book);

//		String email = bookService.getBookOwnerEmailById(4);
//		System.out.println(email);
//
//		String isbn = bookService.getBookIsbnById(2);
//		System.out.println(isbn);

		List<ReportDto> reportDtoList = reportService.getAll();
		System.out.println(reportDtoList.size());

		for (ReportDto reportDto : reportDtoList) {
			System.out.println(reportDto.getReportStatus());
			System.out.println(reportDto.getIsbn());
			System.out.println(reportDto.getUserEmail());
		}

	}

}
