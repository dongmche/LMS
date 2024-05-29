package com.students.lms.service;

import com.students.lms.dto.BookDto;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    public List<BookDto> getAllBook();

    public boolean createBook(BookDto bookDto);

    public boolean updateBook(BookDto bookDto);

    public boolean updateBookUserByBookId(long id, String email, LocalDate localDate);

    public String getBookIsbnById(long id);

    public String getBookOwnerEmailById(long id);

    boolean returnBook(long id);

//    boolean isAvailableById(long id);

    public List<BookDto> findBookByTitle(String title);

    List<BookDto> findOverdueBooks();
}
