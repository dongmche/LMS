package com.students.student_managment_system.mapper;

import com.students.student_managment_system.dto.ReportDto;
import com.students.student_managment_system.entity.Report;
import com.students.student_managment_system.entity.ReportStatus;

public class ReportMapper {
    public static ReportDto mapToReport(Report report){
        return new ReportDto(report.getId(),report.getUserEmail(),
                report.getBookISBN(),
                report.getReportStatus().toString());
    }
    public static Report mapToReport(ReportDto reportDto){
        return null;
    }
}
