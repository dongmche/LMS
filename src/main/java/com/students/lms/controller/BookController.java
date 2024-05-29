package com.students.lms.controller;

import com.students.lms.dto.ReportDto;
import com.students.lms.service.BookService;
import com.students.lms.service.ReportService;
import com.students.lms.service.UserService;
import com.students.lms.dto.BookDto;
import com.students.lms.dto.UserDto;
import com.students.lms.entity.Book;
import com.students.lms.entity.ReportStatus;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    private BookService bookService;
    private UserService userService;
    private ReportService reportService;

    public BookController(BookService bookService, UserService userService, ReportService reportService) {
        this.bookService = bookService;
        this.userService = userService;
        this.reportService = reportService;
    }


    @GetMapping("/book/create")
    public String getBookCreate(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("book", bookDto);
        return "create_book";
    }

    @PostMapping("/book/create")
    public String createBook(@Valid @ModelAttribute("book") BookDto book,
                             BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("book", book);
            return "create_book";
        }

        bookService.createBook(book);
        return "redirect:/book/create";
    }


    // handle books request
    @GetMapping("/books")
    public String getAllBooks(Model model){
        List<BookDto> books = bookService.getAllBook();
        model.addAttribute("books", books);
        model.addAttribute("email", getCurrentUserEmail());
        return "books";
    }

    @GetMapping("/books/current")
    public String getCurrentUserBooks(Model model){
        UserDto userDto = userService.findUserByEmail(getCurrentUserEmail());
        Set<Book> books = userDto.getBooks();
        model.addAttribute("books", books);
        return "books";
    }

    // handle books request
    @GetMapping("/books/borrow/{id}/{duration}")
    public String borrowBook(@PathVariable long id, @PathVariable("duration") int duration){
//        System.out.println(duration);

        String email = getCurrentUserEmail();

        if (bookService.getBookOwnerEmailById(id) == null) {
            bookService.updateBookUserByBookId(id, email, LocalDate.now().plusDays(duration));
            reportService.report(email, bookService.getBookIsbnById(id), ReportStatus.BORROWED);
        }


        return "redirect:/books";
    }

    // handle books request
    @GetMapping("/books/return/{id}")
    public String returnBook(@PathVariable long id) {
        String email = getCurrentUserEmail();
        String ownerEmail = bookService.getBookOwnerEmailById(id);

        if (ownerEmail != null && ownerEmail.equals(email)) {
            bookService.returnBook(id);
            reportService.report(email, bookService.getBookIsbnById(id), ReportStatus.RETURNED);
        }

        return "redirect:/books";
    }

    @GetMapping("/books/search")
    public String searchBook(@RequestParam("search") String title, Model model) {
        List<BookDto> books = bookService.findBookByTitle(title);
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/users/reports")
    public String getAllReports(Model model){
        List<ReportDto> reports = reportService.getAll();
        model.addAttribute("reports", reports);
        return "reports";
    }


    public static String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                return userDetails.getUsername();
            } else {
                return null;
            }
        }
        return null;

    }
}
