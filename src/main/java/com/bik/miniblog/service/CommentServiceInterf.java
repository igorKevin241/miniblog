package com.bik.miniblog.service;

import com.bik.miniblog.dto.CommentReqDto;
import com.bik.miniblog.dto.CommentResDto;

import java.util.List;
import java.util.UUID;

public interface CommentServiceInterf {
    List<CommentResDto> getAllComments();

    CommentResDto createComment(CommentReqDto comment, UUID postId, UUID userId);

    CommentResDto getCommentById(UUID commentId);

    void deleteCommentById(UUID commentId);

    CommentResDto updateComment(CommentReqDto comment);
}
