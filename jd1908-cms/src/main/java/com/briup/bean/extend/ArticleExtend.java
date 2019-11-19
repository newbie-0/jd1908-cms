package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.Comment;
import com.briup.bean.User;

public class ArticleExtend extends Article {
	public static final String STATUS_UNCHECKED = "未审核";
	public static final String STATUS_CHECK_PASS = "审核通过";
	public static final String STATUS_CHECK_NOPASS = "审核不通过";
	
	private Category category;
	
	private List<Comment> comments;
	
	private User author;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
