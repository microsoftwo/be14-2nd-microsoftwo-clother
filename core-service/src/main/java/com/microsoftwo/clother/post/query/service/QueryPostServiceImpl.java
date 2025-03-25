package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dao.QueryPostMapper;
import com.microsoftwo.clother.post.query.dto.HairTagDTO;
import com.microsoftwo.clother.post.query.dto.PostDTO;
import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import com.microsoftwo.clother.post.query.dto.ProductDetailDTO;
import com.microsoftwo.clother.post.query.dto.ProductTagDTO;
import com.microsoftwo.clother.post.query.dto.ResponsePostDetailDTO;
import com.microsoftwo.clother.product.query.dto.ProductForPostDTO;
import com.microsoftwo.clother.product.query.service.ProductService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class QueryPostServiceImpl implements QueryPostService {

    private final QueryPostMapper queryPostMapper;
    private final ProductService productService;

    @Autowired
    public QueryPostServiceImpl(QueryPostMapper queryPostMapper,
                                ProductService productService) {
        this.queryPostMapper = queryPostMapper;
        this.productService = productService;
    }

    @Transactional
    @Override
    public ResponsePostDetailDTO getPostById(int postId) {
        ResponsePostDetailDTO responsePostDetailDTO = new ResponsePostDetailDTO();

        PostDTO postDTO = queryPostMapper.getPostById(postId);

        // 필수 정보 매핑
        responsePostDetailDTO.setId(postDTO.getId());
        responsePostDetailDTO.setUserId(postDTO.getUserId());
        responsePostDetailDTO.setContent(postDTO.getContent());
        responsePostDetailDTO.setCreatedAt(postDTO.getCreatedAt());
        responsePostDetailDTO.setLikeCount(postDTO.getLikeCount());
        responsePostDetailDTO.setCommentCount(postDTO.getCommentCount());
        responsePostDetailDTO.setImageUrls(Arrays.asList(postDTO.getImageUrls().split(","))); // ","로 구분된 이미지 URL 처리

        // 선택 정보 매핑
        if (postDTO.getLookTags() != null) {
            responsePostDetailDTO.setLookTags(Arrays.asList(postDTO.getLookTags().split(",")));   // ","로 구분된 태그 처리
        }

        HairTagDTO hairTagDTO = queryPostMapper.getHairTagByPostId(postId);
        if (hairTagDTO != null) {
            responsePostDetailDTO.setHairTagId(hairTagDTO.getId());
            responsePostDetailDTO.setHairTagName(hairTagDTO.getName());
            responsePostDetailDTO.setHairTagCategoryId(hairTagDTO.getCategoryId());
            responsePostDetailDTO.setHairTagPositionX(hairTagDTO.getHairTagPositionX());
            responsePostDetailDTO.setHairTagPositionY(hairTagDTO.getHairTagPositionY());
        }

        List<ProductTagDTO> productTagDTOs = queryPostMapper.getProductTagByPostId(postId);
        System.out.println("해당 post에 상품 태그가 있는가?");
        System.out.println(Arrays.toString(productTagDTOs.toArray()));

        if (!productTagDTOs.isEmpty()) {
            System.out.println("상품 태그가 있다면");
            List<ProductDetailDTO> productDetailDTOs = new ArrayList<>();
            List<Integer> productTagIds = new ArrayList<>();

            for (ProductTagDTO productTagDTO : productTagDTOs) {
                productTagIds.add(productTagDTO.getProductId());

                ProductDetailDTO productDetailDTO = new ProductDetailDTO(
                        productTagDTO.getId(), // tag 번호
                        productTagDTO.getProductId(), // productId
                        productTagDTO.getProductTagPositionX(),
                        productTagDTO.getProductTagPositionY(),
                        "",
                        "",
                        0,
                        "",
                        "",
                        0,
                        ""
                );

                productDetailDTOs.add(productDetailDTO);
            }

            // Product 정보 가져오기
            List<ProductForPostDTO> products = productService.getProductsByIds(productTagIds);

            // products의 각 항목을 productDetailDTO에 매핑
            for (int i = 0; i < products.size(); i++) {
                ProductForPostDTO product = products.get(i);

                // 해당 제품에 대한 ProductDetailDTO 업데이트
                ProductDetailDTO productDetailDTO = productDetailDTOs.get(i);
                productDetailDTO.setBrandName(product.getBrandName());
                productDetailDTO.setName(product.getName());
                productDetailDTO.setPrice(product.getPrice());
                productDetailDTO.setLink(product.getLink());
                productDetailDTO.setImageUrl(product.getImageUrl());
                productDetailDTO.setCategoryId(product.getCategoryId());
                productDetailDTO.setCategoryName(product.getCategoryName());
            }

            // ResponsePostDetailDTO에 매핑된 ProductDetailDTO 설정
            responsePostDetailDTO.setProducts(productDetailDTOs);
        }

        /* todo. 북마크 여부 요청 */

        /* todo. 좋아요 여부 요청 */

        /* todo. 댓글 정보 요청 */

        /* todo. 회원 정보 요청 */
        
        /* todo. 받은 정보 DTO 합치기 */

        return responsePostDetailDTO;
    }

    @Override
    public List<PostForFeedDTO> getPostFeedOrderByDate(Integer lastPostId) {
        return queryPostMapper.getPostFeedOrderByDate(lastPostId);
    }
}