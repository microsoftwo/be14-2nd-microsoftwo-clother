package com.microsoftwo.clother.query.controller;

import com.microsoftwo.clother.query.dto.UserDTO;
import com.microsoftwo.clother.query.service.UserQueryService;
import com.netflix.discovery.converters.Auto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserQueryController {
    private  UserQueryService userQueryService;

    @Autowired
    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    // 회원 검색 ( 닉네임 )
    @GetMapping
    public List<UserDTO> getUsers(@RequestParam("keyword") String keyword) {
        return userQueryService.getUsers(keyword);
    }

}
