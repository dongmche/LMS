package com.students.student_managment_system.repository;

import com.students.student_managment_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String admin);
//    Role findByName(String name);
}
