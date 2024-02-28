package com.bik.miniblog.dto;

import com.bik.miniblog.entity.Post;
import com.bik.miniblog.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResDto {
    private String content;
    private LocalDateTime createdAt;

    public PostResDto fromPost(Post post) {
        return PostResDto.builder()
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
