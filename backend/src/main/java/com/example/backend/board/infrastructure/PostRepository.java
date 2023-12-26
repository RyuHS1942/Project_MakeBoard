package com.example.backend.board.infrastructure;

import com.example.backend.board.domain.Post;
import com.example.backend.board.infrastructure.dto.ReadPostRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
