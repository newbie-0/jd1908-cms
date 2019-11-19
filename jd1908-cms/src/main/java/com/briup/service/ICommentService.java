package com.briup.service;

import com.briup.bean.Comment;

public interface ICommentService {
	
	public void saveComment(Comment comment);
	
	public void checkComment(Comment comment);
	
}
