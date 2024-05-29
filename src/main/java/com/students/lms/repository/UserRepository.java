package com.students.lms.repository;

import com.students.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

//    User findByUsername(String username);
}
