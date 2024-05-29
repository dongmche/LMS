package com.students.student_managment_system.repository;

import com.students.student_managment_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

//    User findByUsername(String username);
}
