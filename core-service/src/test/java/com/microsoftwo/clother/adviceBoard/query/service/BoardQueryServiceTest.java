package com.microsoftwo.clother.adviceBoard.query.service;
import com.microsoftwo.clother.adviceBoard.query.dao.BoardMapper;
import com.microsoftwo.clother.adviceBoard.query.dto.BoardDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BoardQueryServiceTest {

    private BoardMapper boardMapper;
    private BoardQueryService boardQueryService;

    @BeforeEach
    void setUp() {
        boardMapper = mock(BoardMapper.class);
        boardQueryService = new BoardQueryService(boardMapper);
    }

    @DisplayName("게시글 id로 조회하면 해당 게시글이 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getBoardByIdTest(int boardId) {
        // given
        BoardDTO board = new BoardDTO();
        board.setId(boardId);

        when(boardMapper.getBoradById(boardId)).thenReturn(board);
//
        // when
        BoardDTO result = boardQueryService.getBoardById(boardId);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(boardId);
        verify(boardMapper, times(1)).getBoradById(boardId);
    }
}

