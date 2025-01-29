package com.blogger.controller;

import com.blogger.model.Tag;
import com.blogger.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping
    public List<Tag> getAllTags(){
        return tagService.getAllPosts();
    }
    @GetMapping("/{id}")
    public Tag getTag(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag){
        return  tagService.createTag(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@RequestBody Tag tag, @PathVariable Long id){
        return tagService.updateTag(tag, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteTagById(id);
    }

    @DeleteMapping
    public void deleteAllTag(){
        tagService.deleteAllTags();
    }
}
