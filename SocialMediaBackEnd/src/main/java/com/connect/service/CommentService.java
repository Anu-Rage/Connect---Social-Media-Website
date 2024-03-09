package com.connect.service;

import com.connect.exception.CommentException;
import com.connect.exception.PostException;
import com.connect.exception.UserException;
import com.connect.model.Comments;

public interface CommentService {
	
	public Comments createComment(Comments comment,Integer postId,Integer userId) throws PostException, UserException;
    public Comments createCommentReels(Comments comment,Long reelId,Integer userId) throws PostException, UserException;
	public Comments findCommentById(Integer commentId) throws CommentException;
	public Comments likeComment(Integer CommentId,Integer userId) 
			throws UserException, CommentException;
}
