package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.extend.ArticleExtend;

public interface ArticleExtendMapper {
	
	List<ArticleExtend> selectAll();
	
	ArticleExtend selectById(int id);
	
}
