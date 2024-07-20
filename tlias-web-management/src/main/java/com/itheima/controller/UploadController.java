package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

	@PostMapping("/upload")
	//服务端接收文件一般使用MultipartFile来接收，MultipartFile用于接收
	//image对象
	public Result upload(String username, Integer age, MultipartFile image){
		log.info("文件上传:{},{},{}",username,age,image);
		return Result.success();
	}
}