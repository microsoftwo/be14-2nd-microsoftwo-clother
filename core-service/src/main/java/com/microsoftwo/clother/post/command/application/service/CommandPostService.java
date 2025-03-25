package com.microsoftwo.clother.post.command.application.service;

import com.microsoftwo.clother.post.command.domain.vo.RequestRegistPostVO;

public interface CommandPostService {
    void registPost(RequestRegistPostVO newPost);
}
