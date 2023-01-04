package com.ajmalhakim.postapi.exception;

import com.ajmalhakim.postapi.entity.Post;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long postId, Class<Post> postClass) {
        super("The post with id: "+postId +" does not exist!");
    }
}
