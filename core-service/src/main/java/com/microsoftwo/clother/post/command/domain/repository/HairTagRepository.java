package com.microsoftwo.clother.post.command.domain.repository;

import com.microsoftwo.clother.post.command.domain.aggregate.HairTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairTagRepository extends JpaRepository<HairTagEntity, Integer> {
}
