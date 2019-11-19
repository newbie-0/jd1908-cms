package com.briup.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Comment;
import com.briup.service.ICommentService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "评论相关接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@ApiOperation("保存评论")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "content", value = "评论", required = true, paramType = "query"),
		@ApiImplicitParam(name = "userId", value = "评论者id", required = true, paramType = "query"),
		@ApiImplicitParam(name = "articleId", value = "文章id", required = true, paramType = "query"),
		@ApiImplicitParam(name = "parentId", value = "父评论id", required = true, paramType = "query"),
	})
	@PostMapping("/saveComment")
	public Message saveComment(
			String content, 
			Integer userId, 
			Integer articleId, 
			Integer parentId) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUserId(userId);
		comment.setParentId(parentId);
		comment.setArticleId(articleId);
		commentService.saveComment(comment);
		return MessageUtil.success("保存成功");
	}
	
	@ApiOperation("审核评论")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "评论id", required = true, paramType = "query"),
		@ApiImplicitParam(name = "status", value = "状态", required = true, paramType = "query"),
	})
	@GetMapping("/checkComment")
	public Message checkComment(
			Integer id, 
			String status) {
		Comment comment = new Comment();
		comment.setId(id);
		comment.setStatus(status);
		commentService.checkComment(comment);
		return MessageUtil.success("审核完成");
	}
}
