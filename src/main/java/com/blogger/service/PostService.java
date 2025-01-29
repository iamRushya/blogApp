package com.blogger.service;

import com.blogger.model.Post;
import com.blogger.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found!"));
    }
    
    public Post cratePost(Post post){
       return postRepository.save(post);
    }
    
    public Post updatePost(Post post, Long id){
        Post updatedPost = getPostById(id);
        updatedPost.setTitle(post.getTitle());
        updatedPost.setExcerpt(post.getExcerpt());
        updatedPost.setContent(post.getContent());
        updatedPost.setPublished(post.isPublished());
        return postRepository.save(updatedPost);
    }
    
    public void deletePostById(Long id){
        postRepository.deleteById(id);
    }

    public void deleteAllPosts(){
        postRepository.deleteAll();
    }
}
