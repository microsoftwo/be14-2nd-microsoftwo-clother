package com.microsoftwo.clother.post.query.dao;

import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.ProductTagDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    PostDTO getPostById(int postId);
    HairTagDTO getHairTagByPostId(int postId);
    List<ProductTagDTO> getProductTagByPostId(int postId);
}
