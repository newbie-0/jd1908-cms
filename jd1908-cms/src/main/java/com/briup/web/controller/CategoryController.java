package com.briup.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//栏目管理的控制器类
@Api(description = "栏目相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@ApiOperation("查询所有栏目")
	@GetMapping("/findAll")
	public Message findAll() {
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation("通过id删除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "编号", required = true, paramType = "query")
	})
	@GetMapping("/deleteById")
	public Message deleteById(@RequestParam("id") Integer id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation("批量删除")
	@PostMapping("batchDelete")
	public Message batchDelete(@RequestBody Integer[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("批量删除成功");
	}
	
	@ApiOperation("批量删除")
	@PostMapping("batchDelete_form")
	public Message batchDelete_form(Integer[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("批量删除成功");
	}
	
	@ApiOperation(value = "保存或更新", notes = "保存的时候无需传递id，如果传递id后台会认为你要完成更新操作，将后台数据直接更新为你传递的数据")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	}
}
