package com.students.student_managment_system.dto;

import com.students.student_managment_system.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    private Long id;

    @NotEmpty(message = "title should not be empty")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;


    @NotEmpty(message = "genre should not be empty")
    private String genre;

    @NotEmpty(message = "ibsn should not be empty")
    private String ibsn;


    private User user;

}
