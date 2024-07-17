package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
//加上注解定义日志输出
@Slf4j

@RestController
public class DeptController {

	//由于controller最终是需要调用service的，因此controller需要注入service层的对象
	@Autowired
	//下面是加上了service的对象进行消息注入
	private DeptService deptService;


	//这里定义一个日志记录对象，用于显示日志
	//private static Logger log= (Logger) LoggerFactory.getLogger(DeptController.class);

	//查询信息
	//@RequestMapping用于指定当前接口的请求路径
	@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定接口的请求方式为get

	//@GetMapping("/depts")

	//这里的Result为统一响应结果
	public Result list(){
		log.info("查询全部部门数据");

		//调用service来查询数据
		List<Dept> deptList= deptService.list();

		return Result.success();
	}
}