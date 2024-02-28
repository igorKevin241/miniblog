package com.bik.miniblog.service;

import com.bik.miniblog.dto.CommentReqDto;
import com.bik.miniblog.dto.CommentResDto;
import com.bik.miniblog.entity.Comment;
import com.bik.miniblog.entity.Post;
import com.bik.miniblog.entity.User;
import com.bik.miniblog.repository.CommentRepository;
import com.bik.miniblog.repository.PostRepository;
import com.bik.miniblog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentServiceInterf {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<CommentResDto> getAllComments() {

        List<Comment> comments = commentRepository.findAll();
        List<CommentResDto> commentResDtos = new ArrayList<>();

        for (Comment comment : comments) {
            commentResDtos.add(new CommentResDto().fromComment(comment));
        }
        return commentResDtos;
    }

    @Override
    public CommentResDto createComment(CommentReqDto comment, UUID postId, UUID userId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Comment comment1 = comment.toComment();
        comment1.setPost(post);
        comment1.setUser(user);
        Comment comment2 = commentRepository.save(comment1);
        post.addComment(comment2);
        user.addComment(comment2);
        postRepository.save(post);

        return new CommentResDto().fromComment(comment2);
    }

    @Override
    public CommentResDto getCommentById(UUID commentId) {
        return new CommentResDto().fromComment(commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found!")));
    }

    @Override
    public void deleteCommentById(UUID commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found!"));
        commentRepository.deleteById(comment.getCommentId());

    }

    @Override
    public CommentResDto updateComment(CommentReqDto comment) {
        return new CommentResDto().fromComment(commentRepository.save(comment.toComment()));
    }
}

