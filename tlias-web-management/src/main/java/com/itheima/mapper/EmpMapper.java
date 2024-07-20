package com.itheima.mapper;


import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
//	//查询总记录数
//	@Select("select count(*) from emp")
//	public Long count();
//
//	//查询记录数
//	@Select("select * from emp limit #{start},#{pageSize}")
//	public List<Emp> page(Integer start,Integer pageSize);

	/*
	* 员工信息的查询
	* */
	//pagehelper插件分页查询
	//@Select("select * from emp ")
	//使用xml文件进行动态SQL查询
	public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


	/*
	* 批量删除的操作
	* */
	void delete(List<Integer> ids);
}
