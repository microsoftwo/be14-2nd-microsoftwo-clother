package com.microsoftwo.clother.comment.command.application.service;

import com.microsoftwo.clother.adviceBoard.command.domain.repository.BoardCommandRepository;
import com.microsoftwo.clother.comment.command.application.dto.CommentDTO;
import com.microsoftwo.clother.comment.command.domain.aggregate.Comment;
import com.microsoftwo.clother.comment.command.domain.repository.CommentRepository;
import com.microsoftwo.clother.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardCommandRepository boardCommandRepository;
    private final PostRepository  postRepository;

    @Transactional
    public void createComment(CommentDTO commentDto) {

        // 댓글 저장
        Comment comment = commentDto.toEntity();
        commentRepository.save(comment);

        Integer boardId = commentDto.getBoardId();
        Integer postId = commentDto.getPostId();

        // 댓글 수 증가 로직
        if (boardId != null) {
            boardCommandRepository.increaseCommentCount(boardId);
        } else if (postId != null) {
            postRepository.increaseCommentCount(postId);
        }

    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 존재하지 않습니다: " + commentId));
        comment.setIsDeleted(true);
        commentRepository.save(comment); // 변경된 댓글 저장
    }

}
