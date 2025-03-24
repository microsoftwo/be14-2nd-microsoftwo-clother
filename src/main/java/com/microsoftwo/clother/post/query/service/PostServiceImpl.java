package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dao.PostMapper;
import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostAndHairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.ProductTagDTO;
import com.microsoftwo.clother.post.query.dto.TestPostDTO;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Transactional
    @Override
    public PostAndHairTagDTO getPostById(int postId) {
        PostDTO postDTO = postMapper.getPostById(postId);
        HairTagDTO hairTagDTO = postMapper.getHairTagByPostId(postId);
        List<ProductTagDTO> productTagDTOs = postMapper.getProductTagByPostId(postId);

//        log.debug(Arrays.toString(productTagDTOs.toArray()));

        List<Integer> productTagIds = productTagDTOs.stream()
                .map(ProductTagDTO::getId)
                .toList();

        /* todo. 상품, 카테고리 정보 요청 */
        if (!productTagIds.isEmpty()) {
            // product 도메인에 요청 보내기
            // ex) sendRequestToProductDomain(productTagIds);
        }

        /* todo. 북마크 여부 요청 */

        /* todo. 좋아요 여부 요청 */

        /* todo. 댓글 정보 요청 */

        /* todo. 회원 정보 요청 */


        /* todo. 받은 정보 DTO 합치기 */

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