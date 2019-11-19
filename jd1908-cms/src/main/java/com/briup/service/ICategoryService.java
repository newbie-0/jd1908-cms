package com.briup.service;

import java.util.List;

import com.briup.bean.Category;
import com.briup.util.CustomerException;

public interface ICategoryService {
	List<Category> findAll();
	
	void saveOrUpdate(Category category) throws CustomerException;
	
	public void deleteById(Integer id) throws CustomerException;
	
	public void batchDelete(Integer[] ids) throws CustomerException;
}
