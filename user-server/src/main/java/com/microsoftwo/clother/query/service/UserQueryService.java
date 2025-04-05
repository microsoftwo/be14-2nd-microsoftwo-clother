package com.microsoftwo.clother.query.service;

import com.microsoftwo.clother.query.dto.UserDTO;

import java.util.List;

public interface UserQueryService {

    List<UserDTO> getUsers(String keyword);
}
