package com.bik.miniblog.controller;

import com.bik.miniblog.dto.PostReqDto;
import com.bik.miniblog.dto.PostResDto;
import com.bik.miniblog.dto.UserReqDto;
import com.bik.miniblog.dto.UserResDto;
import com.bik.miniblog.service.PostServiceInterf;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostServiceInterf postServiceInterf;

    public PostController(PostServiceInterf postServiceInterf) {
        this.postServiceInterf = postServiceInterf;
    }

    @GetMapping("/get-all-posts")
    public List<PostResDto> getAllPosts() {

        return postServiceInterf.getAllPosts();
    }

    @PostMapping("/create-post")
    public PostResDto createPost(@RequestBody PostReqDto post, UUID userId) {

        return postServiceInterf.createPost(post, userId);
    }
    @GetMapping("/get-post-by-id")
    public PostResDto getPostById(UUID postId) {

        return postServiceInterf.getPostById(postId);
    }

    @DeleteMapping("/delete-post-by-id")
    public void deletePostById(UUID postId) {

        postServiceInterf.deletePostById(postId);
    }

    @PutMapping("/update-post")
    public PostResDto updatePost(PostReqDto post) {

        return postServiceInterf.updatePost(post);
    }
}


