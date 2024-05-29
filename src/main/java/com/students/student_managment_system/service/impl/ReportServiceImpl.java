package com.students.student_managment_system.service.impl;

import com.students.student_managment_system.repository.ReportRepository;
import com.students.student_managment_system.service.ReportService;
import com.students.student_managment_system.entity.Report;
import com.students.student_managment_system.entity.ReportStatus;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    private ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public boolean report(Report report) {
        reportRepository.save(report);
        return true;
    }

    @Override
    public boolean report(String email, String bookIsbn, ReportStatus reportStatus) {
        Report report = new Report();
        report.setUserEmail(email);
        report.setBookISBN(bookIsbn);
        report.setReportStatus(reportStatus);
        reportRepository.save(report);
        return false;
    }
}
