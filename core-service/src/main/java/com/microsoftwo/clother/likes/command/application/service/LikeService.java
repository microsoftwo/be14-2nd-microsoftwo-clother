package com.microsoftwo.clother.likes.command.application.service;

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

    @Transactional
    public LikeDTO createLike(LikeDTO likeDTO) {
        Like like = likeDTO.toEntity();
        Like savedLike = likeRepository.save(like);
        return LikeDTO.fromEntity(savedLike);
    }


}




