package com.liangfeng.myspringboot.common.manager.id;

import com.liangfeng.myspringboot.common.helper.UUIDHelper;

/**
 * @Title: UUIDGenerator.java
 * @Description: UUID生成算法
 * @author Liangfeng
 * @date 2017/5/1 0001 8:34
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class UUIDGenerator extends IdGenerator{

	@Override
	public <T> T generateId() {
		 return (T) UUIDHelper.generateCompressedUUID();
	}

}
