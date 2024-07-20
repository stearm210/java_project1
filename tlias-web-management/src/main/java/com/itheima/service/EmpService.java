package com.itheima.service;

import com.itheima.pojo.PageBean;

/**
 * 员工管理
 */
public interface EmpService {
	/*
	* 用于分页查询的方法
	* */
	PageBean page(Integer page, Integer pageSize);
}
