package com.microsoftwo.clother.post.command.domain.repository;


import com.microsoftwo.clother.post.command.domain.aggregate.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Modifying
    @Query("UPDATE PostEntity b SET b.likeCount = b.likeCount + 1 WHERE b.id = :postId")
    void increaseLikeCount(Integer postId);

    @Modifying
    @Query("UPDATE PostEntity b SET b.likeCount = b.likeCount - 1 WHERE b.id = :postId")
    void decreaseLikeCount(Integer postId);
}
