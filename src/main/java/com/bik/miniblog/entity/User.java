package com.bik.miniblog.entity;

import com.bik.miniblog.dto.UserReqDto;
import com.bik.miniblog.enums.Genre;
import com.bik.miniblog.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "prenom")
    private String firstname;

    @Column(name = "nom")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "motdepasse")
    private String password;

    @Column(name = "datenaissance")
    private LocalDate datenaissance;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Post> postEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    public void addPost(Post post2) {
        if (!this.postEntities.contains(post2)) {
            this.postEntities.add(post2);
            post2.setUser(this);
        }
    }

    public void addComment(Comment comment2) {
        if (!this.comments.contains(comment2)) {
            this.comments.add(comment2);
            comment2.setUser(this);
        }
    }

    }
