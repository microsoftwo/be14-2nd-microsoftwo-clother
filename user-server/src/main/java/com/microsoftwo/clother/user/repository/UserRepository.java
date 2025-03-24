package com.microsoftwo.clother.user.repository;

import com.microsoftwo.clother.user.aggregate.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmailOrNickname(String email, String nickname);
}
