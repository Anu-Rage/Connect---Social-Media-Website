package com.connect.service;

import java.util.List;

import com.connect.exception.ChatException;
import com.connect.exception.MessageException;
import com.connect.exception.UserException;
import com.connect.model.Message;
import com.connect.request.SendMessageRequest;

public interface MessageService  {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
