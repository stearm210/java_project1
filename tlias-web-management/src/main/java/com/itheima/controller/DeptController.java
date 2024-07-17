package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门管理Controller
 */
@RestController
public class DeptController {

	//查询信息
	@RequestMapping("/depts")
	public Result list(){
		System.out.println("查询全部部门数据");
		return Result.success();
	}
}