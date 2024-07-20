package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
	/*
	* 用于分页查询的方法
	* */
	PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

	/*
	* 批量删除操作
	* */
	void delete(List<Integer> ids);

	/*
	* 添加数据操作
	* */
	void save(Emp emp);
}
