package com.students.lms.mapper;

import com.students.lms.dto.ReportDto;
import com.students.lms.entity.Report;

public class ReportMapper {
    public static ReportDto mapToReportDto(Report report){
        return new ReportDto(report.getId(),report.getUserEmail(),
                report.getBookISBN(),
                report.getReportStatus().toString());
    }
    public static Report mapToReport(ReportDto reportDto){
        return null;
    }
}
