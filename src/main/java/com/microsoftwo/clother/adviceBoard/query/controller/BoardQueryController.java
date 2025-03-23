package com.microsoftwo.clother.adviceBoard.query.controller;

import com.microsoftwo.clother.adviceBoard.query.dto.BoardDTO;
import com.microsoftwo.clother.adviceBoard.query.service.BoardQueryService;
import io.micrometer.common.util.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@Data
@Slf4j
public class BoardQueryController {

    private final BoardQueryService boardQueryService;

    // 게시판 조회
    @GetMapping
    public List<BoardDTO> getBoards(@RequestParam(required = false) String sortBy) {
        return boardQueryService.getBoards(sortBy);
    }
}

