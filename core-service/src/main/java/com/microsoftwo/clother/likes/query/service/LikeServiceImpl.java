package com.microsoftwo.clother.likes.query.service;

import com.microsoftwo.clother.likes.query.dto.LikeDTO;
import com.microsoftwo.clother.likes.query.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public List<LikeDTO> getUserLikes(int userId) {
        return likeMapper.findLikedItemsByUserId(userId);
    }
}
