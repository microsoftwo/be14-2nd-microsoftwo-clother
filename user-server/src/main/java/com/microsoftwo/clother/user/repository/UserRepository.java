package com.microsoftwo.clother.user.repository;

import com.microsoftwo.clother.user.aggregate.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmailOrNickname(@Email @NotEmpty(message = "이메일을 입력해 주세요") String email,
                                               @NotEmpty(message = "닉네임을 입력해 주세요") String nickname);
}
