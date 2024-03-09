package com.connect.service;

import java.util.List;

import com.connect.exception.PostException;
import com.connect.exception.UserException;
import com.connect.model.Reels;
import com.connect.model.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUsersReel(Integer userId) throws UserException;
	public Reels findReelsById(Long reelId) throws PostException;
	public Reels likeReel(Long reelId , Integer userId) throws UserException, PostException;

}
