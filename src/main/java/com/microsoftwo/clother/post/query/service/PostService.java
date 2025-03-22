package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;

public interface PostService {
    TestPostDTO test();

    PostDTO getPostById(int postId);
}
