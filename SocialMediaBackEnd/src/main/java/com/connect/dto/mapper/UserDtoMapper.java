package com.connect.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.connect.dto.PostDto;
import com.connect.dto.ReelsDto;
import com.connect.dto.UserDto;
import com.connect.dto.UserProfileDto;
import com.connect.model.User;

public class UserDtoMapper {
	
	
	
	public static UserProfileDto reqUserDTO(User user,User reqUser) {
		UserProfileDto userProfileDto =new UserProfileDto();
		List<PostDto> savedPost=PostDtoMapper.toPostDtos(user.getSavedPosts(),reqUser);
		List<PostDto> reposts=PostDtoMapper.toPostDtos(user.getReposts(),reqUser);
		List<UserDto> followers = userDTOS(new ArrayList<>(user.getFollower()));
		List<UserDto> followings = userDTOS(new ArrayList<>(user.getFollowing()));
		List<ReelsDto> reels = ReelsDtoMapper.toReelsDtos(user.getSavedReels(),reqUser);

		userProfileDto.setEmail(user.getEmail());
		userProfileDto.setId(user.getId());
		userProfileDto.setFirstName(user.getFirstName());
		userProfileDto.setLastName(user.getLastName());
		userProfileDto.setImage(user.getImage());
		userProfileDto.setBio(user.getBio());
		userProfileDto.setGender(user.getGender());
		userProfileDto.setId(user.getId());
		userProfileDto.setMobile(user.getMobile());
		userProfileDto.setWebsite(user.getWebsite());

		userProfileDto.setReposts(reposts);
		userProfileDto.setSavedPosts(savedPost);
		
//		userProfileDto.setStories(null);
		userProfileDto.setReels(reels);

		userProfileDto.setFollower(followers);
		userProfileDto.setFollowing(followings);
		
		return userProfileDto;
	}
	
	public static UserDto userDTO(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setImage(user.getImage());;
		
		return userDto;
	}
	
	public static List<UserDto> userDTOS(List<User> list){
		List<UserDto> userDtos = new ArrayList<>();
		
		for(User user : list) {
			UserDto userDto= userDTO(user);
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
