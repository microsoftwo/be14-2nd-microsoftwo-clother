package com.microsoftwo.clother.report.query.service;

import com.microsoftwo.clother.report.query.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    List<ReportDTO> getReports(String orderById);
}
