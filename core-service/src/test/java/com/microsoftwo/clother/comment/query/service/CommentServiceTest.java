package com.microsoftwo.clother.comment.query.service;


import com.microsoftwo.clother.comment.command.application.dto.CommentDTO;
import com.microsoftwo.clother.comment.command.application.service.CommentService;
import com.microsoftwo.clother.comment.command.domain.aggregate.Comment;
import com.microsoftwo.clother.comment.command.domain.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    public CommentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCommentTest() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUserId(1);
        commentDTO.setContent("테스트 댓글");

        Comment comment = commentDTO.toEntity();
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

//        CommentDTO savedComment = commentService.createComment(commentDTO);

//        assertNotNull(savedComment);
//        assertEquals("테스트 댓글", savedComment.getContent());
    }
}
