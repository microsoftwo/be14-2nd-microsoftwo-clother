package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;

public interface PostService {

    PostAndHairTagDTO getPostById(int postId);
}
