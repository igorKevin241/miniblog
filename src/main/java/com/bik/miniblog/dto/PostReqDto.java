package com.bik.miniblog.dto;

import com.bik.miniblog.entity.Post;
import com.bik.miniblog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReqDto {
    private String content;
    private LocalDateTime createdAt;

    public Post toPost() {
        return Post.builder()
                .content(content)
                .createdAt(createdAt)
                .build();

    }
}
