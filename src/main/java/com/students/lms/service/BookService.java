package com.students.student_managment_system.service;

import com.students.student_managment_system.dto.BookDto;

import java.util.List;

public interface BookService {
    public List<BookDto> getAllBook();

    public boolean createBook(BookDto bookDto);

    public boolean updateBook(BookDto bookDto);

    public boolean updateBookUserByBookId(long id, String email);

    public String getBookIsbnById(long id);

    public String getBookOwnerEmailById(long id);

    boolean returnBook(long id);

//    boolean isAvailableById(long id);

    public List<BookDto> findBookByTitle(String title);
}
