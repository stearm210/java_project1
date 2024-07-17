package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
	/*
	* 这个方法主要是用于查询全部的部门数据的
	* mapper直接在接口中使用注解SQL语句的形式进行开发*/
	@Select("select * from dept")

	//在dept数据库当中查询到的信息会使用一个list进行返回
	List<Dept> list();
}
