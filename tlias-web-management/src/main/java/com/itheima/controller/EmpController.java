package com.itheima.controller;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
//同一路径问题
@RequestMapping("/emps")
public class EmpController {

	//注入service接口
	@Autowired
	private EmpService empService;

	@GetMapping
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

	//批量删除操作
	@DeleteMapping("/{ids}")

	//@PathVariable注解的作用是将 URL 中的路径变量绑定到方法的参数上
	//1.当 URL 中包含占位符（如 /users/{id}）时，@PathVariable 注解可以将占位符的值提取出来作为方法参数的值。
	///users/{id} 可以匹配任意用户 ID 的请求，而 @PathVariable 注解可以将实际的用户 ID 提取出来，供方法使用。
	public Result delete(@PathVariable List<Integer> ids){
		log.info("批量删除操作,ids:{}",ids);
		empService.delete(ids);
		return Result.success();
	}


	//增加员工数据问题
	@PostMapping
	//使用实体类作为接收参数时使用@RequestBody注解
	public Result save(@RequestBody Emp emp){
		log.info("新增员工,emp:{}",emp);
		empService.save(emp);
		return Result.success();
	}
}