package com.microsoftwo.clother.comment.query.mapper;

import com.microsoftwo.clother.comment.query.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDTO> findCommentByType(@Param("type") String type,
                                       @Param("id") int id );}
