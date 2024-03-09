package com.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connect.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
