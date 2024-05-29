package com.students.student_managment_system.repository;

import com.students.student_managment_system.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
