package com.microsoftwo.clother.adviceBoard.query.service;

import com.microsoftwo.clother.adviceBoard.query.dto.BoardDTO;

import java.util.List;

public interface BoardQueryService {
    List<BoardDTO> getBoards(String sortBy);

    BoardDTO getBoardById(int postId);

    List<BoardDTO> searchBoards(String sortBy, String keyword);

}
