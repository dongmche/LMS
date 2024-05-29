package com.students.student_managment_system.mapper;

import com.students.student_managment_system.dto.BookDto;
import com.students.student_managment_system.entity.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setIbsn(book.getIbsn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setGenre(book.getGenre());
        bookDto.setUser(book.getUser());

        return bookDto;
    }
    public static Book mapToBook(BookDto bookDto){
        Book book = new Book();

        book.setIbsn(bookDto.getIbsn());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setUser(bookDto.getUser());


        return book;
    }
}
