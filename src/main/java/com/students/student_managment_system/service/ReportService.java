package com.students.student_managment_system.service;

import com.students.student_managment_system.entity.Report;
import com.students.student_managment_system.entity.ReportStatus;

public interface ReportService {
    public boolean report(Report report);

    public boolean report(String email, String bookIsbnById, ReportStatus reportStatus);
}
