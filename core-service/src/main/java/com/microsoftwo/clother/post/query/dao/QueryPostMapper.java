package com.microsoftwo.clother.post.query.dao;

import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import com.microsoftwo.clother.post.query.dto.ProductTagDTO;
import com.microsoftwo.clother.post.query.dto.RequestFeedDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryPostMapper {

    PostDTO getPostById(int postId);
    HairTagDTO getHairTagByPostId(int postId);
    List<ProductTagDTO> getProductTagByPostId(int postId);

    List<PostForFeedDTO> selectFeed(RequestFeedDTO requestFeedDTO);
}
