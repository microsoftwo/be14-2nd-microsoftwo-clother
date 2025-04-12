package com.microsoftwo.clother.likes.command.application.service;

import com.microsoftwo.clother.adviceBoard.command.domain.repository.BoardCommandRepository;
import com.microsoftwo.clother.comment.command.domain.repository.CommentRepository;
import com.microsoftwo.clother.likes.command.domain.aggregate.Like;
import com.microsoftwo.clother.likes.command.domain.repository.LikeRepository;
import com.microsoftwo.clother.likes.command.domain.vo.RequestLikeVO;
import com.microsoftwo.clother.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final BoardCommandRepository boardCommandRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createLike(RequestLikeVO requestLikeVO, int userId) {

        Integer boardId = requestLikeVO.getBoardId();
        Integer postId = requestLikeVO.getPostId();
        Integer commentId = requestLikeVO.getCommentId();

        boolean alreadyExists =
                (boardId != null && likeRepository.existsByUserIdAndBoardId(userId, boardId)) ||
                        (postId != null && likeRepository.existsByUserIdAndPostId(userId, postId)) ||
                        (commentId != null && likeRepository.existsByUserIdAndCommentId(userId, commentId));

        if (alreadyExists) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }

        Like like = Like.builder()
                .userId(userId)
                .postId(postId)
                .boardId(boardId)
                .commentId(commentId)
                .build();

        likeRepository.save(like);

        if (boardId != null) {
            boardCommandRepository.increaseLikeCount(boardId);
        } else if (postId != null) {
            postRepository.increaseLikeCount(postId);
        } else if (commentId != null) {
            commentRepository.increaseLikeCount(commentId);
        }
    }

    @Transactional
    public void deleteLike(int likeId, int userId) {
        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 ID를 찾을 수 없습니다: " + likeId));

        if (like.getUserId() != userId) {
            throw new SecurityException("해당 좋아요에 대한 삭제 권한이 없습니다.");
        }

        if (like.getBoardId() != null) {
            boardCommandRepository.decreaseLikeCount(like.getBoardId());
        } else if (like.getPostId() != null) {
            postRepository.decreaseLikeCount(like.getPostId());
        } else if (like.getCommentId() != null) {
            commentRepository.decreaseLikeCount(like.getCommentId());
        }

        likeRepository.deleteById(likeId);
    }
}
