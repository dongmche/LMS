package com.students.lms.dto;


import com.students.lms.entity.Book;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;

    @NotEmpty(message = "firstName can not be empty")
    private String firstName;

    @NotEmpty(message = "lastName can not be empty")
    private String lastName;

    @NotEmpty(message = "email can not be empty")
    @Email
    private String email;

    @NotEmpty(message = "password can not be empty")
    private String password;

    private Set<Book> books = new HashSet<>();

}
