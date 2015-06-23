/*
 * 文件名： Configuration.java
 * 
 *
 * 创建日期： 2014年12月19日
 *
 * Copyright(C) 2014, by hai
 *
 * 原始作者: 陶盛龙
 *
 */
package com.dragon.common.util;

import java.util.ResourceBundle;

/**
 * 
 * 
 * @author 陶盛龙
 * 
 * @version
 * 
 * @since 2014年12月19日
 */
public class Configuration {
	private static Object lock = new Object();
	private static Configuration config = null;
	private static ResourceBundle rb = null;

	/**
	 * 
	 * 功能描述：根据配置文件名读取相关参数。文件必须处于classes目录下。
	 * 
	 * @constructor 方法
	 */
	private Configuration(String configName) {
		rb = ResourceBundle.getBundle(configName);
	}

	public static Configuration getInstance(String configName) {
		synchronized (lock) {
			if (null == config) {
				config = new Configuration(configName);
			}
		}
		return (config);
	}

	public String getValue(String key) {
		return (rb.getString(key));
	}
}
