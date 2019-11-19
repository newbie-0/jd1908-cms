package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.extend.ArticleExtend;
import com.briup.util.CustomerException;

public interface IArticleService {
	
	List<Article> findAll();
	
	List<ArticleExtend> cascadeFindAll();
	
	ArticleExtend findById(Integer id);
	
	void saveOrUpdate(Article article) throws CustomerException;
	
	public void deleteById(Integer id) throws CustomerException;
	
}
