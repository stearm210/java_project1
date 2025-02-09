package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	//注解注入操作
	@Autowired
	private EmpMapper empMapper;

//	@Override
//	public PageBean page(Integer page, Integer pageSize) {
//		//1.获取总记录数
//		Long count=empMapper.count();
//		//2.获取分页查询的结果列表
//		Integer start=(page-1)*pageSize;
//		List<Emp> empList = empMapper.page(start, pageSize);
//
//		//3.封装pageBean对象
//		PageBean pageBean = new PageBean(count, empList);
//
//		return pageBean;
//	}


	///插件分页查询
	@Override
	public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
		//1.设置分页参数
		//选择查询范围
		PageHelper.startPage(page,pageSize);
		//2.执行查询
		List<Emp> empList = empMapper.list(name, gender, begin, end);
		Page<Emp> p=(Page<Emp>) empList;

		//3.封装pageBean对象
		PageBean pageBean = new PageBean(p.getTotal(),p.getResult());

		return pageBean;
	}

	/*
	* 批量删除
	* */
	@Override
	public void delete(List<Integer> ids) {
		empMapper.delete(ids);
	}

	/*
	* 新增员工操作
	* */
	@Override
	public void save(Emp emp) {
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.insert(emp);
	}
}