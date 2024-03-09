package com.connect.controller;

import java.util.List;

import com.connect.exception.PostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.connect.dto.ReelsDto;
import com.connect.dto.mapper.ReelsDtoMapper;
import com.connect.exception.UserException;
import com.connect.model.Reels;
import com.connect.model.User;
import com.connect.service.ReelsService;
import com.connect.service.UserService;

@RestController
@RequestMapping("/api/reels")
public class ReelsController {
	
	@Autowired
	private ReelsService reelsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ReelsDto> createReels(@RequestBody Reels reel,
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		Reels newReels=reelsService.createReel(reel, user);
		
		ReelsDto reelsDto=ReelsDtoMapper.toReelsDto(newReels, user);
		
		return new ResponseEntity<>(reelsDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<ReelsDto>> getAllReels(
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		List<Reels> reels=reelsService.findAllReels();
		
		List<ReelsDto> reelsDtos=ReelsDtoMapper.toReelsDtos(reels, user);
		
		return new ResponseEntity<>(reelsDtos,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ReelsDto>> getUsersReels(
			@RequestHeader("Authorization") String jwt,@PathVariable Integer userId) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		List<Reels> reels=reelsService.findUsersReel(userId);
		
		List<ReelsDto> reelsDtos=ReelsDtoMapper.toReelsDtos(reels, user);
		
		return new ResponseEntity<>(reelsDtos,HttpStatus.ACCEPTED);
	}

	@PutMapping("/like/{reelId}")
	public ResponseEntity<ReelsDto> likePostHandler(
			@PathVariable("reelId") Long reelId,
			@RequestHeader("Authorization") String token) throws UserException, PostException {

		User user=userService.findUserProfileByJwt(token);

		Reels updatedReel=reelsService.likeReel(reelId, user.getId());

		ReelsDto reelsDto = ReelsDtoMapper.toReelsDto(updatedReel,user);

		return new ResponseEntity<>(reelsDto, HttpStatus.CREATED);

	}
}
