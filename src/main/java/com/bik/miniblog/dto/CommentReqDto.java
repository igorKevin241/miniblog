package com.bik.miniblog.dto;

import com.bik.miniblog.entity.Comment;
import com.bik.miniblog.entity.Post;
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
public class CommentReqDto {
    private String commentContent;
    private LocalDateTime createdAt;

    public Comment toComment() {
        return Comment.builder()
                .commentContent(commentContent)
                .createdAt(createdAt)
                .build();

    }
}
