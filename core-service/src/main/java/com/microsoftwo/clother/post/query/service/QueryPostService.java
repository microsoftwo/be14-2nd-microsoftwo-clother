package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import com.microsoftwo.clother.post.query.dto.RequestFeedDTO;
import com.microsoftwo.clother.post.query.dto.ResponsePostDetailDTO;
import java.util.List;

public interface QueryPostService {

    ResponsePostDetailDTO getPostById(int postId);

    List<PostForFeedDTO> getFeed(RequestFeedDTO requestFeedDTO);
}
