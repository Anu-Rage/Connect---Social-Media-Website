package com.connect.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String video;
	
	@ManyToOne
	private User user;

	@OneToMany
	private List<Comments> comments=new ArrayList<Comments>();

	@ManyToMany
	private Set<User> liked= new HashSet<>();

}
