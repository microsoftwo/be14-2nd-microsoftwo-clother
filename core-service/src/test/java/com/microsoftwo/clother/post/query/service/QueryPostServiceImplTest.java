package com.microsoftwo.clother.post.query.service;

import com.microsoftwo.clother.post.query.dto.PostForFeedDTO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueryPostServiceImplTest {

    @Autowired
    private QueryPostServiceImpl queryPostServiceImpl;

    @DisplayName("피드 9개씩 최신순 조회")
    @Test
    void testGetPostsOrderByDate() {
        Assertions.assertDoesNotThrow(
                () -> {
                    queryPostServiceImpl.getPostFeedOrderByDate(null);
                }
        );

        List<PostForFeedDTO> posts = queryPostServiceImpl.getPostFeedOrderByDate(null);
        Assertions.assertEquals(9, posts.size());
    }


}