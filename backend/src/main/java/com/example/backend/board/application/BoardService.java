package com.example.backend.board.application;

import com.example.backend.board.domain.Post;
import com.example.backend.board.infrastructure.PostRepository;
import com.example.backend.board.infrastructure.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final PostRepository postRepository;

    public BoardService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void create(CreatePostRequest request) {
        Post post = postRepository.save(new Post(request.getPostTitle(), request.getPostContent()));
    }

    public List<ReadBoardResponse> read() {
        List<Post> list = postRepository.findAll();

        return toResponseList(list);
    }

    public Optional<Post> readInfo(ReadPostRequest request) {
        Optional<Post> post = postRepository.findById(request.getPostId());

        return post;
    }

    @Transactional
    public Post update(UpdatePostRequest request) {
        Post post = postRepository.findById(request.getPostId()).get();
        post.setPostTitle(request.getPostTitle());
        post.setPostContent(request.getPostContent());
        return post;
    }

    @Transactional
    public void delete(ReadPostRequest request) {
        postRepository.deleteById(request.getPostId());
    }

    private static List<ReadBoardResponse> toResponseList(List<Post> list) {
        return list.stream().map(post -> {
            ReadBoardResponse boardResponse = new ReadBoardResponse();
            BeanUtils.copyProperties(post, boardResponse);
            return boardResponse;
        }).collect(Collectors.toList());
    }
}
