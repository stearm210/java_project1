package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

	/*
	* 这里与上面那一层的意思是一样的，也是需要注入下一层的信息。也就是说，service层是需要调用mapper层的*/
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> list() {
		return deptMapper.list();//这里调用mapper的方法查询信息
	}

	@Override
	public void delete(Integer id) {
		deptMapper.deleteById(id);
	}
}