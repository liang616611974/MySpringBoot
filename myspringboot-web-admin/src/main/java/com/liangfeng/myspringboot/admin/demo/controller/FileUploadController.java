/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.liangfeng.myspringboot.admin.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Title: FileUploadController.java
 * @Description: 文件上传测试
 * @author Liangfeng
 * @date 2017/4/27 0027 上午 11:53
 * @version 1.0
 */
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);


	@RequestMapping(value = "/file/index")
	public String index(ModelMap map) {
		map.put("title", "freemarker hello word");
		return "demo/fileupload/index"; // 开头不要加上/，linux下面会出错
	}

	@RequestMapping(value = "/file/upload")
	@ResponseBody
	public String upload(@RequestParam("lfFile") MultipartFile file) {
		if (file.isEmpty()) {
			return "文件为空";
		}

		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);

		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);

		// 文件上传路径
		String filePath = "D:/Backup Files/upload/";

		// 解决中文问题，liunx下中文路径，图片显示问题
		fileName = UUID.randomUUID() + suffixName;
		
		File dest = new File(filePath + fileName);

		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}

		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}

}
