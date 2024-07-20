package com.itheima.controller;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {

	//注入service接口
	@Autowired
	private EmpService empService;

	@GetMapping("/emps")
	//这里使用@RequestParam来设置默认值
	//@DateTimeFormat注解用于声明日期的形式
	public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
		//if (page == null) page=1;
		//if (pageSize == null) pageSize=10;
		log.info("分页查询，参数:{},{},{},{},{}",page,pageSize,name,gender,begin,end);

		//调用service层方法
		//返回pagebean对象
		PageBean pageBean=empService.page(page,pageSize,name,gender,begin,end);

		//像这种多类型数据，上面已经封装成了一个对象返回，这里只需要返回统一结果Result
		return Result.success(pageBean);


	}
}