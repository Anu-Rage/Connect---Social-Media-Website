package com.connect.service;

import java.util.List;

import com.connect.exception.StoryException;
import com.connect.exception.UserException;
import com.connect.model.Story;

public interface StoryService {

	public Story createStory(Story story,Integer userId) throws UserException;
	
	public List<Story> findStoryByUserId(Integer userId) throws UserException, StoryException;
	
	
}
