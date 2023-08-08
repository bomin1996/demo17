package com.example.helloworld.controller;

import com.example.helloworld.model.Post;
import com.example.helloworld.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.getPostById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deletePost(id);
    }
}