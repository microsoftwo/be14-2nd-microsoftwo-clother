package com.microsoftwo.clother.comment.query.service;

import com.microsoftwo.clother.comment.query.dto.CommentDTO;
import com.microsoftwo.clother.comment.query.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDTO> getComments(String type, int id) {
        return commentMapper.findCommentByType(type,id);
    }
}
