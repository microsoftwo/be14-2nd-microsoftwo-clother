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
    public List<ReportDTO> getReports(String orderById) {
        if(!List.of("ASC", "DESC").contains(orderById.toUpperCase())) {
            orderById = "ASC";
        }
        return reportMapper.findAllReports(orderById);
    }
}
