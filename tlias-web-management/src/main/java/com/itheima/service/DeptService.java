package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

	/*
	* 查询全部部门数据
	*
	* 这里的接口时service的接口，主要是定义函数壳。
	* 函数的实现在impl下的java文件中进行实现*/

	List<Dept> list();

	/*
	* 删除信息操作
	* */
	void delete(Integer id);

	/*
	* 增加信息操作
	* */
	void add(Dept dept);
}
