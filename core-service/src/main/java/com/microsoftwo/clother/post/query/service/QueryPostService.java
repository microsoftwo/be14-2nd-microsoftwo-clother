package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import java.util.List;

public interface QueryPostService {

    PostAndHairTagDTO getPostById(int postId);

    List<PostForFeedDTO> getPostFeedOrderByDate(Integer lastPostId);
}
