package com.blogger.controller;

import com.blogger.model.Comment;
import com.blogger.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateCommentById(@RequestBody Comment comment,@PathVariable Long id){
        return commentService.updateComment(comment, id);
    }

    @DeleteMapping
    public void deleteCommentById(@PathVariable Long id){
        commentService.deleteCommentById(id);
    }

    @DeleteMapping
    public void deleteAllComments(){
        commentService.deleteAllComments();
    }


}
