package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.extend.ArticleExtend;
import com.briup.dao.ArticleMapper;
import com.briup.dao.extend.ArticleExtendMapper;
import com.briup.service.IArticleService;
import com.briup.util.CustomerException;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	public List<Article> findAll() {
		return articleMapper.selectByExample(new ArticleExample());
	}
	
	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(Article article) throws CustomerException {
		if (article.getId() != null) {
			articleMapper.updateByPrimaryKey(article);
		} else {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if (list.size() > 0) {
				throw new CustomerException("文章标题不能重复");
			}
			
			//初始化
			article.setStatus(ArticleExtend.STATUS_UNCHECKED);
			article.setThumbUp(0);
			article.setThumbDown(0);
			article.setPublishTime(new Date());
			article.setReadTime(0);
			articleMapper.insert(article);
		}
	}

	@Override
	public ArticleExtend findById(Integer id) {
		return articleExtendMapper.selectById(id);
	}
	
	@Override
	public void deleteById(Integer id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		if (article == null) {
			throw new CustomerException("该文章不存在");
		} else {
			articleMapper.deleteByPrimaryKey(id);
		}
	}

}
