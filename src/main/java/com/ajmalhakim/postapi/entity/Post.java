package com.ajmalhakim.postapi.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    @NotBlank(message = "title cannot be blank")
    private String title;
    @NotBlank(message = "body cannot be blank")
    private String body;
    @DateTimeFormat(pattern = "dd-MMM-yyyy HH:mm")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(Long id, @NonNull String title, String body, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
