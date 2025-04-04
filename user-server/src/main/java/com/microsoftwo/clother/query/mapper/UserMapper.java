package com.microsoftwo.clother.query.mapper;

import com.microsoftwo.clother.query.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> getUsers(@Param("keyword") String keyword);
}
