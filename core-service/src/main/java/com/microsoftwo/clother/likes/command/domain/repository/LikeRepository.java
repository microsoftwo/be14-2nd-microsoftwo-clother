package com.microsoftwo.clother.likes.command.domain.repository;

import com.microsoftwo.clother.likes.command.domain.aggregate.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
