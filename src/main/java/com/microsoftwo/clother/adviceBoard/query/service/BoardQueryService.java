package com.microsoftwo.clother.adviceBoard.query.service;

import com.microsoftwo.clother.adviceBoard.query.dao.BoardMapper;
import com.microsoftwo.clother.adviceBoard.query.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class BoardQueryService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardQueryService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 게시판 조회
    public List<BoardDTO> getBoards(String sortBy) {
        // 기본값: 최신순
        if (!"like".equals(sortBy)) {
            sortBy = "created_at";
        }
        return boardMapper.getBoards(sortBy);
    }

    // 게시물 조회
    public BoardDTO getBoardById(int id) {
        return boardMapper.getBoradById(id);
    }


}
