package com.electronics.projects.service;

import com.electronics.projects.model.Comment;

public interface CommentService {
    
    Comment getCommentById(Integer id);
    
    Comment saveOrUpdate(Comment comment);
}
