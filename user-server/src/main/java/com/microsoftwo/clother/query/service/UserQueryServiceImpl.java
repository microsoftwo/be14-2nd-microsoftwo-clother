package com.microsoftwo.clother.query.service;

import com.microsoftwo.clother.query.mapper.UserMapper;
import com.microsoftwo.clother.query.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserQueryServiceImpl implements UserQueryService {
    private UserMapper userMapper;

    @Autowired
    public UserQueryServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 회원 조회 ( 닉네임 )
    @Override
    public List<UserDTO> getUsers(String keyword) {
        return userMapper.getUsers(keyword);
    }

    // 회원 조회 ( UserId )
    @Override
    public UserDTO getUser(int userId) {
        return userMapper.getUser(userId);
    }
}
