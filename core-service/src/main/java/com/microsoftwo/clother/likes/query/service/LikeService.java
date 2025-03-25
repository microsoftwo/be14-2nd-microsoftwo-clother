package com.microsoftwo.clother.likes.query.service;

import com.microsoftwo.clother.likes.query.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    List<LikeDTO> getUserLikes(int userId);
}
