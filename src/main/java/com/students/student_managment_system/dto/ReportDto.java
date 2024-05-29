package com.students.student_managment_system.dto;

import com.students.student_managment_system.entity.Book;
import com.students.student_managment_system.entity.ReportStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDto {
    private Long id;
    private String userEmail;
    private String isbn;
    private String  reportStatus;

}
