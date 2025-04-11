package com.microsoftwo.clother.post.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueryPostServiceImplTest {

    @Autowired
    private QueryPostServiceImpl queryPostServiceImpl;

    @DisplayName("피드 조회")
    @Test
    void testGetPostsOrderByDate() {
        Assertions.assertDoesNotThrow(
                () -> {
                    queryPostServiceImpl.getFeed(null);
                }
        );
    }


}