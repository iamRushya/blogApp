package com.blogger.service;


import com.blogger.model.Tag;
import com.blogger.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    List<Tag> getAll(){
        return tagRepository.findAll();
    }

    Tag getTagById(Long id){
        return tagRepository.findById(id).orElseThrow(()-> new RuntimeException("Tag not found!"));
    }

    Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

    Tag updateTag(Tag tag, Long id){
        Tag udatedTag = getTagById(id);
        udatedTag.setName(tag.getName());
        return tagRepository.save(tag);
    }

    void deleteTagById(Long id){
        tagRepository.deleteById(id);
    }

    void deleteAllTags(){
        tagRepository.deleteAll();
    }
}
