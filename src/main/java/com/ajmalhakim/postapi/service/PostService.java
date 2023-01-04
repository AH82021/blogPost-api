package com.ajmalhakim.postapi.service;

import com.ajmalhakim.postapi.entity.Post;

import java.util.List;

public interface PostService {
    Post getPost(Long postId);
    List<Post> getAllPosts();
    Post savePost(Post post);
    Post updatePost(Post post);
    void deletePost(Long postId);
}
