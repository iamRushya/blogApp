package com.blogger.service;

import com.blogger.model.Comment;
import com.blogger.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

   public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

   public Comment getCommentById(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new RuntimeException("Comment not found!"));
    }

   public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

   public Comment updateComment(Comment comment, Long id){
        Comment udpatedcomment = getCommentById(id);
        udpatedcomment.setComment(comment.getComment());

        return commentRepository.save(udpatedcomment);
    }

   public void deleteCommentById(Long id){
        commentRepository.deleteById(id);
    }

   public void deleteAllComments(){
        commentRepository.deleteAll();
    }
}
