package com.blogger.service;


import com.blogger.model.Tag;
import com.blogger.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

   public List<Tag> getAllPosts(){
        return tagRepository.findAll();
    }

   public Tag getTagById(Long id){
        return tagRepository.findById(id).orElseThrow(()-> new RuntimeException("Tag not found!"));
    }

   public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

   public Tag updateTag(Tag tag, Long id){
        Tag udatedTag = getTagById(id);
        udatedTag.setName(tag.getName());
        return tagRepository.save(tag);
    }

   public void deleteTagById(Long id){
        tagRepository.deleteById(id);
    }

   public void deleteAllTags(){
        tagRepository.deleteAll();
    }
}
