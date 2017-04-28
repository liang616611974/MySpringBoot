package com.lf.common.helper;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * @Title: IOHelper.java
 * @Description: IO流操作帮助类
 * @author Liangfeng
 * @date 2017/4/28 0028 上午 10:09
 * @version 1.0
 */
public class IOHelper {

	/**
	 * 私有化
	 */
	private IOHelper(){}
	
	/**
	 * 获取文件输入流，支持classpath:表达式
	 * @param filePath
	 * @return
	 */
	public static InputStream getInputStream(String filePath) {
		InputStream is = null;
		try{
			is = new FileInputStream(FileHelper.getFile(filePath));
		}catch (Exception e) {
			return null;
		}
		return is;
	}

	
		
}
