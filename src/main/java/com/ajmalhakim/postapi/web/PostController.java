package com.ajmalhakim.postapi.web;

import com.ajmalhakim.postapi.entity.Post;
import com.ajmalhakim.postapi.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId){
        return new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Post>> getPosts(){
        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Post> savePost(@RequestBody @Valid Post post){
        return new ResponseEntity<>(postService.savePost(post),HttpStatus.CREATED);
    }
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId,@RequestBody @Valid Post post){
        return new ResponseEntity<>(postService.updatePost(post), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Post> deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
