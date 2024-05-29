package com.students.lms.service;

import com.students.lms.dto.ReportDto;
import com.students.lms.entity.Report;
import com.students.lms.entity.ReportStatus;

import java.util.List;

public interface ReportService {
    public boolean report(Report report);

    public boolean report(String email, String bookIsbnById, ReportStatus reportStatus);

    public List<ReportDto> getAll();
}
