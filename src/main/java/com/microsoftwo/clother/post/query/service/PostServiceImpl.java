package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dao.PostMapper;
import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public PostAndHairTagDTO getPostById(int postId) {
        PostDTO postDTO = postMapper.getPostById(postId);
        HairTagDTO hairTagDTO = postMapper.getHairTagByPostId(postId);

        PostAndHairTagDTO postAndHairTagDTO = new PostAndHairTagDTO();
        mergePostAndHairTag(postDTO, postAndHairTagDTO, hairTagDTO);

        return postAndHairTagDTO;
    }

    private static void mergePostAndHairTag(PostDTO postDTO, PostAndHairTagDTO postAndHairTagDTO, HairTagDTO hairTagDTO) {
        if (postDTO != null) {
            postAndHairTagDTO.setId(postDTO.getId());
            postAndHairTagDTO.setUserId(postDTO.getUserId());
            postAndHairTagDTO.setContent(postDTO.getContent());
            postAndHairTagDTO.setCreatedAt(postDTO.getCreatedAt());
            postAndHairTagDTO.setLikeCount(postDTO.getLikeCount());
            postAndHairTagDTO.setCommentCount(postDTO.getCommentCount());

            List<String> imageUrls = null;
            if (postDTO.getImageUrls() != null) {
                imageUrls = Arrays.stream(postDTO.getImageUrls().split(",")).toList();
                postAndHairTagDTO.setImageUrls(imageUrls);
            }

            List<String> lookTags = null;
            if (postDTO.getLookTags() != null) {
                lookTags = Arrays.stream(postDTO.getLookTags().split(",")).toList();
                postAndHairTagDTO.setLookTags(lookTags);
            }
        }

        if (hairTagDTO != null) {
            postAndHairTagDTO.setHairTagId(hairTagDTO.getId());
            postAndHairTagDTO.setHairTagLink(hairTagDTO.getLink());
            postAndHairTagDTO.setHairTagName(hairTagDTO.getName());
            postAndHairTagDTO.setHairTagCategoryId(hairTagDTO.getCategoryId());
            postAndHairTagDTO.setHairTagPositionX(hairTagDTO.getHairTagPositionX());
            postAndHairTagDTO.setHairTagPositionY(hairTagDTO.getHairTagPositionY());
        }
    }
}
