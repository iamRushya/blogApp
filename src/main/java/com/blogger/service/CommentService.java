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

    List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    Comment getCommentById(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new RuntimeException("Comment not found!"));
    }

    Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    Comment updateComment(Comment comment, Long id){
        Comment udpatedcomment = getCommentById(id);
        udpatedcomment.setComment(comment.getComment());

        return commentRepository.save(udpatedcomment);
    }

    void deleteCommentByid(Long id){
        commentRepository.deleteById(id);
    }

    void deleteAllComments(){
        commentRepository.deleteAll();
    }
}
