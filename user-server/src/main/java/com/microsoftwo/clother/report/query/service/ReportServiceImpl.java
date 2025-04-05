package com.microsoftwo.clother.report.query.service;

import com.microsoftwo.clother.report.query.dto.ReportDTO;
import com.microsoftwo.clother.report.query.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    @Autowired
    public ReportServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    // 신고 최신순 조회
    @Override
    public List<ReportDTO> getReports(String sortDirection, String status) {
        if (sortDirection == null || !List.of("ASC", "DESC").contains(sortDirection.toUpperCase().trim())) {
            sortDirection = "ASC";      // 기본값 ASC
        }
        if (status == null || !List.of("N", "T", "F").contains(status.toUpperCase())) {
            status = "N";
        }
        return reportMapper.findAllReports(sortDirection.toUpperCase(), status.toUpperCase());
    }
}
