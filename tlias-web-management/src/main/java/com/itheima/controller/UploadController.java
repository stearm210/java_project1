package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

	@PostMapping("/upload")
	//服务端接收文件一般使用MultipartFile来接收，MultipartFile用于接收文件、图片对象

	public Result upload(String username, Integer age, MultipartFile image) throws IOException {
		log.info("文件上传:{},{},{}",username,age,image);
		//获取原始文件名
		String originalFilename = image.getOriginalFilename();

		//将文件存储到服务器的磁盘目录中
		image.transferTo(new File("E:\\java study\\datebase\\"+originalFilename));

		return Result.success();
	}
}