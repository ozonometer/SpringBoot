package com.electronics.projects.service;

import com.electronics.projects.model.Comment;
import com.electronics.projects.repository.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    
    final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepo.getById(id);
    }

    @Override
    public Comment saveOrUpdate(Comment comment) {
        return commentRepo.save(comment);
    }


}
