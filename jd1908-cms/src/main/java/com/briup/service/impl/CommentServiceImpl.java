package com.briup.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Comment;
import com.briup.dao.CommentMapper;
import com.briup.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Resource
	private CommentMapper commentMapper;
	
	@Override
	public void saveComment(Comment comment) {
		comment.setStatus(Comment.STATUS_UNCHECKED);
		comment.setCommentTime(new Date());
		commentMapper.insert(comment);
	}

	@Override
	public void checkComment(Comment comment) {
		commentMapper.updateByPrimaryKeySelective(comment);
	}

}
