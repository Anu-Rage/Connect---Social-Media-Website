package com.connect.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.connect.dto.CommentDto;
import com.connect.dto.ReelsDto;
import com.connect.dto.UserDto;
import com.connect.model.Reels;
import com.connect.model.User;
import com.connect.utils.ReelsUtils;

public class ReelsDtoMapper {
	
	
	public static ReelsDto toReelsDto(Reels reel, User user) {
		ReelsDto reelsDto=new ReelsDto();
		
		UserDto userDto=UserDtoMapper.userDTO(reel.getUser());
		List<User> likedUsers=new ArrayList<>(reel.getLiked());
		List<UserDto> userDtos=UserDtoMapper.userDTOS(likedUsers);
		List<CommentDto> comments=CommentDtoMapper.toCommentDtos(reel.getComments());
		
		reelsDto.setTitle(reel.getTitle());
		reelsDto.setUser(userDto);
		reelsDto.setVideo(reel.getVideo());
		reelsDto.setId(reel.getId());
		reelsDto.setLiked(userDtos);
		reelsDto.setComments(comments);
		reelsDto.setLikedByRequser(ReelsUtils.isLikedByReqUser(reel, user));
		reelsDto.setSavedByRequser(ReelsUtils.isSaved(reel, user));
		
		return reelsDto;
		
	}
	
	public static List<ReelsDto> toReelsDtos(List<Reels> reels, User user){
		
		List<ReelsDto> reelsDtos=new ArrayList<>();
		
		for(Reels reel : reels ) {
			 ReelsDto reelsDto=toReelsDto(reel,user);
			 reelsDtos.add(reelsDto);
		}
		
		return reelsDtos;
		
	}

}
