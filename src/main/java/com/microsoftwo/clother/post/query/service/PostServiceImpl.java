package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dao.PostMapper;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public TestPostDTO test() {
        return postMapper.test();
    }

    @Override
    public PostDTO getPostById(int postId) {
        return postMapper.getPostById(postId);
    }
}
