package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
//加上注解定义日志输出
@Slf4j

@RestController
public class DeptController {

	//这里定义一个日志记录对象，用于显示日志
	//private static Logger log= (Logger) LoggerFactory.getLogger(DeptController.class);

	//查询信息
	//@RequestMapping用于指定当前接口的请求路径
	@RequestMapping("/depts")
	//这里的Result为统一响应结果
	public Result list(){
		log.info("查询全部部门数据");
		return Result.success();
	}
}