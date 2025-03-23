package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;

public interface PostService {
    TestPostDTO test();

    PostAndHairTagDTO getPostById(int postId);
}
