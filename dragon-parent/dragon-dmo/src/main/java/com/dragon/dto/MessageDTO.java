package com.dragon.dto;

/**
 * 参数包
 * @author Administrator
 *
 */
public class MessageDTO {

	//是否成功标记 0：成功 1：失败 -1：异常
	private String flag;
	
	//原因
	private String cause;
	
	//数据集
	private String recordSet;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getRecordSet() {
		return recordSet;
	}

	public void setRecordSet(String recordSet) {
		this.recordSet = recordSet;
	}
	
	
}
