package com.connect.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.connect.dto.CommentDto;
import com.connect.dto.PostDto;
import com.connect.dto.UserDto;
import com.connect.model.Post;
import com.connect.model.User;
import com.connect.utils.PostUtils;

public class PostDtoMapper {
	
	public static PostDto toPostDto(Post post,User user) {
		
		UserDto userDto=UserDtoMapper.userDTO(post.getUser());
		List<User> likedUsers=new ArrayList<>(post.getLiked());
		List<UserDto> userDtos=UserDtoMapper.userDTOS(likedUsers);
		List<CommentDto> comments=CommentDtoMapper.toCommentDtos(post.getComments());
		
		PostDto postDto=new PostDto();
		postDto.setCaption(post.getCaption());
		postDto.setCreatedAt(post.getCreatedAt());
		postDto.setId(post.getId());
		postDto.setImage(post.getImage());
		postDto.setUser(userDto);
		postDto.setLiked(userDtos);
		postDto.setComments(comments);
		postDto.setLikedByRequser(PostUtils.isLikedByReqUser(post, user));
		postDto.setSavedByRequser(PostUtils.isSaved(post, user));
		
		return postDto;
		
	}
	
	public static List<PostDto> toPostDtos(List<Post> posts, User user){
		List<PostDto> postDtos=new ArrayList<>();
		
		for(Post post:posts) {
			PostDto postDto=toPostDto(post,user);
			postDtos.add(postDto);
		}
		return postDtos;
	}

}
