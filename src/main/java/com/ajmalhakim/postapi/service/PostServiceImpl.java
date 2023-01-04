package com.ajmalhakim.postapi.service;

import com.ajmalhakim.postapi.entity.Post;
import com.ajmalhakim.postapi.exception.PostNotFoundException;
import com.ajmalhakim.postapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    @Override
    public Post getPost(Long postId) {

       Optional<Post> opPost = postRepository.findById(postId);
       if(opPost.isPresent()){
           return opPost.get();
       } else
           throw  new PostNotFoundException(postId,Post.class);
    }

    @Override
    public List<Post> getAllPosts() {

        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        Optional<Post> opPost = postRepository.findById(post.getId());
        if (opPost.isPresent()) {
            opPost.get().setTitle(post.getTitle());
            opPost.get().setBody(post.getBody());
            opPost.get().setUpdatedAt(LocalDateTime.now());
         return    savePost(opPost.get());
        } else throw new PostNotFoundException(post.getId(), Post.class);

    }


    @Override
    public void deletePost(Long postId) {
        Optional<Post> opPost = postRepository.findById(postId);
        if (opPost.isPresent()) {
            postRepository.deleteById(postId);
        }else throw new PostNotFoundException(postId,Post.class);
    }
}
