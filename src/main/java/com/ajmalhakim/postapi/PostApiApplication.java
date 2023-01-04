package com.ajmalhakim.postapi;

import com.ajmalhakim.postapi.entity.Post;
import com.ajmalhakim.postapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PostApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PostApiApplication.class, args);
    }
@Autowired
    PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        List<Post> posts = Arrays.asList(
                new Post(1L,"Your Honor","Crime Tv series", LocalDateTime.now(),LocalDateTime.now()),
                new Post(2L,"Prison Break","Crime Tv series", LocalDateTime.now(),LocalDateTime.now()),
                new Post(3L,"Mr.Robot","Si-fi Tv series", LocalDateTime.now(),LocalDateTime.now()),
                new Post(4L,"Transformers","Si-fi Tv series", LocalDateTime.now(),LocalDateTime.now()),
                new Post(5L,"Lord of the rings","Fiction Tv series", LocalDateTime.now(),LocalDateTime.now())

        );
        for (Post post:posts
             ) {
            postRepository.save(post);
        }
    }
}
