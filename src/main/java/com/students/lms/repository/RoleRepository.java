package com.students.lms.repository;

import com.students.lms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String admin);
//    Role findByName(String name);
}
