package com.students.lms.repository;

import com.students.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> searchBook(@Param("title") String title);

    @Query("SELECT u.email FROM Book b JOIN b.user u WHERE b.id = :id")
    String findBookOwnerEmailById(@Param("id") long id);

    @Query("SELECT b.ibsn FROM Book b WHERE b.id = :id")
    String getBookIsbnById(@Param("id") long id);


    @Query("SELECT b FROM Book b WHERE b.dueDate > :date")
    List<Book> findOverdueBooks(@Param("date") LocalDate date);
}
