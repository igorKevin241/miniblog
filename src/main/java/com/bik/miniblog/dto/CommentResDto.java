package com.bik.miniblog.dto;

import com.bik.miniblog.entity.Comment;
import com.bik.miniblog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResDto {
    private String commentContent;
    private LocalDateTime createdAt;

    public CommentResDto fromComment(Comment comment) {
        return CommentResDto.builder()
                .commentContent(comment.getCommentContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
