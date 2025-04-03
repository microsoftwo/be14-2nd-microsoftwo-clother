package com.microsoftwo.clother.likes.command.application.service;

import com.microsoftwo.clother.adviceBoard.command.domain.repository.BoardCommandRepository;
import com.microsoftwo.clother.adviceBoard.query.service.BoardQueryServiceImpl;
import com.microsoftwo.clother.comment.command.domain.repository.CommentRepository;
import com.microsoftwo.clother.likes.command.application.dto.LikeDTO;
import com.microsoftwo.clother.likes.command.domain.aggregate.Like;
import com.microsoftwo.clother.likes.command.domain.repository.LikeRepository;
import com.microsoftwo.clother.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final BoardCommandRepository boardCommandRepository ;
    private final PostRepository postRepository ;
    private final CommentRepository commentRepository ;

    @Transactional
    public void createLike(LikeDTO likeDTO) {

        Integer userId = likeDTO.getUserId();
        Integer boardId = likeDTO.getBoardId();
        Integer postId = likeDTO.getPostId();
        Integer commentId = likeDTO.getCommentId();

        //  중복 좋아요 체크
        boolean alreadyExists =
                (boardId != null && likeRepository.existsByUserIdAndBoardId(userId, boardId)) ||
                        (postId != null && likeRepository.existsByUserIdAndPostId(userId, postId)) ||
                        (commentId != null && likeRepository.existsByUserIdAndCommentId(userId, commentId));


        if (alreadyExists) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }

        // 좋아요 저장
        Like like = likeDTO.toEntity();
        likeRepository.save(like);

        // 좋아요 수 증가 로직
        if (boardId != null) {
            boardCommandRepository.increaseLikeCount(boardId);
        } else if (postId != null) {
            postRepository.increaseLikeCount(postId);
        } else if (commentId != null) {
            commentRepository.increaseLikeCount(commentId);
        }

    }

    @Transactional
    public void deleteLike(int id) {
        if (likeRepository.existsById(id)) {
            likeRepository.deleteById(id); // JPA를 활용한 ID로 삭제
        } else {
            throw new IllegalArgumentException("좋아요 ID를 찾을 수 없습니다: " + id);
        }

    }
}




