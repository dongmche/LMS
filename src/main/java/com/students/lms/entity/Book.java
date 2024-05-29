package com.students.lms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;

    @Column(nullable = false, unique = true)
    private String ibsn;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate dueDate;


//    @Transient
//    private boolean isOverdue = false;
//
//    @PostLoad
//    public void calculateIfOverdue(){
//        if (this.dueDate.isBefore(LocalDate.now())) {
//            this.isOverdue = true;
//        }
//
//    }



}
