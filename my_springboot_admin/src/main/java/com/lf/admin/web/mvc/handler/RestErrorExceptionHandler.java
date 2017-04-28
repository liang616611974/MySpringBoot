package com.lf.admin.common.web.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * 
 * @author hugovon
 * @version 1.0
 */
@RestControllerAdvice
public class RestErrorExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestErrorExceptionHandler.class);

	/**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            exception
	 * @return
	 */
	@ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.OK)
	public Object processException(RuntimeException exception) {
		logger.info("自定义异常处理-RuntimeException");
		Map<String, Object> strObjs = new HashMap<>();
		strObjs.put("code", 500);
		strObjs.put("错误",exception.getMessage());
		return strObjs;
	}

	/**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            exception
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public Object processException(Exception exception) {
		logger.info("自定义异常处理-Exception");
		Map<String, Object> strObjs = new HashMap<>();
		strObjs.put("code", 500);
		strObjs.put("错误",exception.getMessage());
		return strObjs;
	}

}
