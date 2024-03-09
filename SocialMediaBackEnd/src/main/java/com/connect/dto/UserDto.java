package com.connect.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	

	private String firstName;
	private String lastName;
	private String email;
	private Integer id;
	private String image;
	
}
