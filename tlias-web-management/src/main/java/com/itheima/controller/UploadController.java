package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

	@PostMapping("/upload")
	//服务端接收文件一般使用MultipartFile来接收，MultipartFile用于接收文件、图片对象

	public Result upload(String username, Integer age, MultipartFile image) throws IOException {
		log.info("文件上传:{},{},{}",username,age,image);
		//获取原始文件名
		String originalFilename = image.getOriginalFilename();

		//构造唯一的上传文件名，防止被后续上传文件覆盖 --uuid
		//获取文件名最后一个点所在的位置
		int index = originalFilename.lastIndexOf(".");
		//获得文件的拓展名
		String extname = originalFilename.substring(index);
		//拼接uuid的后缀,使得变成一个新的文件名
		String newFileName = UUID.randomUUID().toString()+extname;
		//输出日志
		log.info("新的文件名:{}",newFileName);


		//将文件存储到服务器的磁盘目录中
		image.transferTo(new File("E:\\java study\\datebase\\"+newFileName));

		return Result.success();
	}
}