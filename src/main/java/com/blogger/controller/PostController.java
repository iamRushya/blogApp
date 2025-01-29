package com.blogger.controller;

import com.blogger.model.Post;
import com.blogger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.cratePost(post);
    }

    @PutMapping("/{id}")
    public  Post updatePost(@RequestBody Post post , @PathVariable Long id){
        return postService.updatePost(post, id);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
    }

    @DeleteMapping
    public void deleteAllPosts(){
        postService.deleteAllPosts();
    }


}
