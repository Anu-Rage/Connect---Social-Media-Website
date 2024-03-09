package com.connect.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReelsDto {
	
	private Long id;
	private String title;
	private String video;
	
	private UserDto user;

	private List<CommentDto> comments=new ArrayList<>();

	private List<UserDto> liked= new ArrayList<>();

	private boolean likedByRequser;

	private boolean savedByRequser;

}
