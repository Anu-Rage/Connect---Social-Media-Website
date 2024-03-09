package com.connect.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.connect.model.Reels;
import com.connect.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect.exception.CommentException;
import com.connect.exception.PostException;
import com.connect.exception.UserException;
import com.connect.model.Comments;
import com.connect.model.Post;
import com.connect.model.User;
import com.connect.repository.CommentRepository;
import com.connect.repository.PostRepository;

@Service
public class CommentsServiceImplement implements CommentService {
	
	@Autowired
	private CommentRepository repo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepo;

	@Autowired
	private ReelsService reelsService;

	@Autowired
	private ReelsRepository reelsRepository;

	
	
	@Override
	public Comments createComment(Comments comment, Integer postId, Integer userId) throws PostException, UserException {
		
		User user=userService.findUserById(userId);
		
		Post post=postService.findePostById(postId);
		
		comment.setUser(user);
		comment.setCreatedAt(LocalDateTime.now());
		Comments newComment= repo.save(comment);
		
		post.getComments().add(newComment);
		
		postRepo.save(post);
		
		return newComment;
	}

	@Override
	public Comments createCommentReels(Comments comment, Long reelId, Integer userId) throws PostException, UserException {
		User user=userService.findUserById(userId);

		Reels reel=reelsService.findReelsById(reelId);

		comment.setUser(user);
		comment.setCreatedAt(LocalDateTime.now());
		Comments newComment= repo.save(comment);

		reel.getComments().add(newComment);

        reelsRepository.save(reel);

		return newComment;
	}


	@Override
	public Comments findCommentById(Integer commentId) throws CommentException {
		Optional<Comments> opt=repo.findById(commentId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CommentException("comment not exist with id : "+commentId);
	}

	@Override
	public Comments likeComment(Integer commentId, Integer userId) throws UserException, CommentException {
	
		User user=userService.findUserById(userId);
		Comments comment=findCommentById(commentId);
		
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else 	comment.getLiked().remove(user);
		

		return repo.save(comment);
		
	}
	
	
	

}
