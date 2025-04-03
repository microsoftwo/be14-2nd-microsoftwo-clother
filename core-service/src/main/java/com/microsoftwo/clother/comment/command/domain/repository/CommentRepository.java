package com.microsoftwo.clother.comment.command.domain.repository;

import com.microsoftwo.clother.comment.command.domain.aggregate.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Modifying
    @Query("UPDATE Comment b SET b.likeCount = b.likeCount + 1 WHERE b.id = :commentId")
    void increaseLikeCount(Integer commentId);
}