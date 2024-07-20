package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	//注解注入操作
	@Autowired
	private EmpMapper empMapper;

	@Override
	public PageBean page(Integer page, Integer pageSize) {
		//1.获取总记录数
		Long count=empMapper.count();
		//2.获取分页查询的结果列表
		Integer start=(page-1)*pageSize;
		List<Emp> empList = empMapper.page(start, pageSize);

		//3.封装pageBean对象
		PageBean pageBean = new PageBean(count, empList);

		return pageBean;
	}
}