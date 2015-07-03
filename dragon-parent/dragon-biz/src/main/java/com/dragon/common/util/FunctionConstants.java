package com.dragon.common.util;

public class FunctionConstants {

	//菜单类型
	public final static String FUNCTION_MENU_TYPE = "MENU";
	
	//活跃状态
	public final static String OFTEN_STATUS_ACTIVE = "ACTIVE";
	
	//取消状态
	public final static String OFTEN_STATUS_CANCELED = "CANCELED";

	public final static String NARMAL_FILE_PATH;

	public final static String SMALL_FILE_PATH;

	public final static String HOME_IMPRESS = "IMPRESS";

	public final static String ROOT_FILE_PATH;

	static{
		Configuration cfg = Configuration.getInstance("constant");
		NARMAL_FILE_PATH = cfg.getValue("normalFilePath");
		SMALL_FILE_PATH = cfg.getValue("smallFilePath");
		ROOT_FILE_PATH = cfg.getValue("rootFilePath");
	}
}
