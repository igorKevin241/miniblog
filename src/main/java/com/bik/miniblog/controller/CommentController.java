package com.bik.miniblog.controller;

import com.bik.miniblog.dto.CommentReqDto;
import com.bik.miniblog.dto.CommentResDto;
import com.bik.miniblog.dto.PostReqDto;
import com.bik.miniblog.dto.PostResDto;
import com.bik.miniblog.service.CommentServiceInterf;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentServiceInterf commentServiceInterf;

    public CommentController(CommentServiceInterf commentServiceInterf) {
        this.commentServiceInterf = commentServiceInterf;
    }

    @GetMapping("/get-all-comments")
    public List<CommentResDto> getAllComments() {

        return commentServiceInterf.getAllComments();
    }

    @PostMapping("/create-comment")
    public CommentResDto createComment(@RequestBody CommentReqDto comment, UUID postId, UUID userId) {

        return commentServiceInterf.createComment(comment, postId, userId);
    }
    @GetMapping("/get-comment-by-id")
    public CommentResDto getCommentById(UUID commentId) {

        return commentServiceInterf.getCommentById(commentId);
    }

    @DeleteMapping("/delete-comment-by-id")
    public void deleteCommentById(UUID commentId) {

        commentServiceInterf.deleteCommentById(commentId);
    }

    @PutMapping("/update-comment")
    public CommentResDto updateComment(CommentReqDto comment) {

        return commentServiceInterf.updateComment(comment);
    }
}
