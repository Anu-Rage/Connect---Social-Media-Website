package com.connect.service;

import java.util.List;
import java.util.Optional;

import com.connect.exception.PostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect.exception.UserException;
import com.connect.model.Reels;
import com.connect.model.User;
import com.connect.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService {
	
	@Autowired
	private ReelsRepository reelsRepositoy;
	
	@Autowired
	private UserService userService;

	@Override
	public Reels createReel(Reels reel,User user) {
		Reels createdReel = new Reels();
		
		createdReel.setTitle(reel.getTitle());
		createdReel.setUser(user);
		createdReel.setVideo(reel.getVideo());
		
		return reelsRepositoy.save(createdReel);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepositoy.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws UserException {
		userService.findUserById(userId);
		return reelsRepositoy.findByUserId(userId);
	}

	@Override
	public Reels findReelsById(Long reelId) throws PostException {
		Optional<Reels> opt = reelsRepositoy.findById(reelId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new PostException("Post not exist with id: "+reelId);
	}


	@Override
	public Reels likeReel(Long reelId, Integer userId) throws UserException, PostException {
		User user= userService.findUserById(userId);

		Reels reel=findReelsById(reelId);

		if(!reel.getLiked().contains(user)) {
			reel.getLiked().add(user);
		}
		else {
			reel.getLiked().remove(user);
		}

		return reelsRepositoy.save(reel);

	}

}
