package com.microsoftwo.clother.report.query.mapper;

import com.microsoftwo.clother.report.query.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {

    // 신고 조회
    List<ReportDTO> findAllReports(@Param("sortDirection") String sortDirection, @Param("status") String status);
}
