package com.students.student_managment_system.repository;

import com.students.student_managment_system.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> searchBook(@Param("title") String title);

    @Query("SELECT u.email FROM Book b JOIN b.user u WHERE b.id = :id")
    String findBookOwnerEmailById(@Param("id") long id);

    @Query("SELECT b.ibsn FROM Book b WHERE b.id = :id")
    String getBookIsbnById(@Param("id") long id);
}
