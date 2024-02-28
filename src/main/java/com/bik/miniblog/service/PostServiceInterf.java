package com.bik.miniblog.service;

import com.bik.miniblog.dto.PostReqDto;
import com.bik.miniblog.dto.PostResDto;

import java.util.List;
import java.util.UUID;

public interface PostServiceInterf {
    List<PostResDto> getAllPosts();

    PostResDto createPost(PostReqDto post, UUID userId);

    PostResDto getPostById(UUID postId);

    void deletePostById(UUID postId);

    PostResDto updatePost(PostReqDto post);
}
