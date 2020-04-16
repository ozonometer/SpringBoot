package com.electronics.projects.repository;

import com.electronics.projects.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {
    
    Comment getById(Integer Id);
    
    List<Comment> getAllByProjectId(Integer id);
}
