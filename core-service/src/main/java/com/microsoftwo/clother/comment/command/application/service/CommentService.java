package com.microsoftwo.clother.comment.command.application.service;

import com.microsoftwo.clother.comment.command.application.dto.CommentDTO;
import com.microsoftwo.clother.comment.command.domain.aggregate.Comment;
import com.microsoftwo.clother.comment.command.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentDTO createComment(CommentDTO commentDto) {
        Comment comment = commentDto.toEntity();
        Comment savedComment = commentRepository.save(comment);
        return CommentDTO.fromEntity(savedComment);
    }


}
