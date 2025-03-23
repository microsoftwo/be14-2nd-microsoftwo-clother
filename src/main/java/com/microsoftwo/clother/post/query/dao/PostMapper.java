package com.microsoftwo.clother.post.query.dao;

import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    TestPostDTO test();

    PostDTO getPostById(int postId);

    HairTagDTO getHairTagByPostId(int postId);
}
