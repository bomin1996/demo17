package com.example.helloworld.repository;

import com.example.helloworld.model.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {

    private static final Map<Long, Post> posts = new HashMap<>();
    private static final AtomicLong idGenerator = new AtomicLong(1);

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }
    public Post getPostById(Long id) {
        return posts.get(id);
    }
    public void deletePost(Long id) {
        posts.remove(id);
    }
}