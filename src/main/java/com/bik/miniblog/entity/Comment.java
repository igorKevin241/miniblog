package com.bik.miniblog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private UUID commentId;

    @Column(name = "content")
    private String commentContent;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "post_id",
            nullable = false,
            referencedColumnName = "post_id",
            foreignKey = @ForeignKey(name = "post_comment_fk")
    )
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "user_comment_fk")
    )
    private User user;

}
