package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.dao.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.util.CustomerException;

//栏目管理的实现类
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if (category.getId() != null) {
			categoryMapper.updateByPrimaryKey(category);
		} else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if (list.size() > 0) {
				throw new CustomerException("栏目不可以重名");
			}
			categoryMapper.insertSelective(category);
		}
	}

	@Override
	public void deleteById(Integer id) throws CustomerException {
		Category category = categoryMapper.selectByPrimaryKey(id);
		if (category == null) {
			throw new CustomerException("该栏目不存在");
		}
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(Integer[] ids) throws CustomerException {
		for (Integer id : ids)
			deleteById(id);
	}

}
