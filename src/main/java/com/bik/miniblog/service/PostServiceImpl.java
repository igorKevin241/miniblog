package com.bik.miniblog.service;

import com.bik.miniblog.dto.PostReqDto;
import com.bik.miniblog.dto.PostResDto;
import com.bik.miniblog.dto.UserResDto;
import com.bik.miniblog.entity.Post;
import com.bik.miniblog.entity.User;
import com.bik.miniblog.repository.PostRepository;
import com.bik.miniblog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostServiceInterf {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostResDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        List<PostResDto> postResDtos = new ArrayList<>();

        for (Post post : posts) {
            postResDtos.add(new PostResDto().fromPost(post));
        }
        return postResDtos;
    }

    @Override
    public PostResDto createPost(PostReqDto post,UUID userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
        Post post1 = post.toPost();
        post1.setUser(user);
        Post post2 = postRepository.save(post1);
        user.addPost(post2);
        userRepository.save(user);

        return new PostResDto().fromPost(post2);

    }

    @Override
    public PostResDto getPostById(UUID postId) {
        return new PostResDto().fromPost(postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found!")));
    }

    @Override
    public void deletePostById(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found!"));
        postRepository.deleteById(post.getPostId());

    }

    @Override
    public PostResDto updatePost(PostReqDto post) {
        return new PostResDto().fromPost(postRepository.save(post.toPost()));
    }
}
