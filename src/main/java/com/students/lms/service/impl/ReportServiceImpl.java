package com.students.lms.service.impl;

import com.students.lms.dto.ReportDto;
import com.students.lms.entity.Book;
import com.students.lms.mapper.BookMapper;
import com.students.lms.mapper.ReportMapper;
import com.students.lms.repository.ReportRepository;
import com.students.lms.service.ReportService;
import com.students.lms.entity.Report;
import com.students.lms.entity.ReportStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ReportDto> getAll() {
        List<Report> reports= reportRepository.findAll();
        return reports.stream()
                .map(report -> ReportMapper.mapToReportDto(report))
                .collect(Collectors.toList());
    }
}
