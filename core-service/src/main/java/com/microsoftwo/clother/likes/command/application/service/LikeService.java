package com.microsoftwo.clother.likes.command.application.service;

import com.microsoftwo.clother.adviceBoard.query.service.BoardQueryServiceImpl;
import com.microsoftwo.clother.likes.command.application.dto.LikeDTO;
import com.microsoftwo.clother.likes.command.domain.aggregate.Like;
import com.microsoftwo.clother.likes.command.domain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final BoardQueryServiceImpl boardQueryService;

    @Transactional
    public LikeDTO createLike(LikeDTO likeDTO) {
        Like like = likeDTO.toEntity();
        Like savedLike = likeRepository.save(like);

        // post에 요청

        // adviceBoard에 요청

        return LikeDTO.fromEntity(savedLike);
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




