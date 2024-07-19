package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


	/*
	* 查询部门信息操作
	* */
	//查询信息
	//@RequestMapping用于指定当前接口的请求路径
	@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定接口的请求方式为get

	//@GetMapping("/depts")

	//这里的Result为统一响应结果
	//list是一个查询函数
	public Result list(){
		log.info("查询全部部门数据");

		//调用service来查询数据
		List<Dept> deptList= deptService.list();

		//这里接收mapper返回的信息并输出
		return Result.success(deptList);
	}



	/*
	* 删除部门信息操作
	* */

	//这里注解中的括号值参考接口文档进行编写
	@DeleteMapping("/depts/{id}")
	//由于是获取接口路径id，因此需要在delete括号中加上注解@PathVariable进行id绑定
	public Result delete(@PathVariable Integer id){
		log.info("根据id删除部门:{}",id);
		//调用service删除
		deptService.delete(id);
		return Result.success();
	}


	/*
	* 增加数据操作
	* */
	@PostMapping("/depts")
	//由于需要使用类对象进行数据的接收，因此调用了注解@RequestBody进行类对象的接收
	public Result add(@RequestBody Dept dept){
		log.info("新增部门:{}",dept);
		//调用service中的方法完成新增部门的操作
		deptService.add(dept);
		return Result.success();
	}
}