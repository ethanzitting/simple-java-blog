package com.example.springbootblogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootblogapplication.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
}
