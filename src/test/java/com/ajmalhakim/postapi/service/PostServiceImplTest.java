package com.ajmalhakim.postapi.service;

import com.ajmalhakim.postapi.entity.Post;
import com.ajmalhakim.postapi.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;



import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    @InjectMocks
 private PostServiceImpl postService;
    @Mock
 private PostRepository postRepository;

    private Post post;
    @BeforeEach
    void setUp() {
        post = new Post(1L,"How write unite tests"," By using @Mock and @InjectMocks annotations", LocalDateTime.now(),LocalDateTime.now());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPost() {
    }

    @Test
    void getAllPosts() {
    }

    @Test
    void savePost() {
        //Arrange
    when(postRepository.save(any(Post.class))).thenReturn(post);
    //Act

   Post newPost =  postService.savePost(post);

   assertNotNull(newPost);







    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}