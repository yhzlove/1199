package com.y.entity;
/**
 * 数据库日志类
 * @author yanhz
 * 2016年10月12日 上午11:08:36
 * <P>Title:Log</P>
 * <P>TODO</P>
 */
public class Log {
	
	
	
	private String description;			//方法描述
	private String ExceptionCode;		//异常代码
	private String Type;				//
	private String ExceptionDetail;		//异常信息
	private String Method;				//请求方法
	private String Params;				//请求参数
	private String CreateBy;			//用户
	private String CreateDate;			//日期
	private String RequestIp;			//请求IP
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExceptionCode() {
		return ExceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		ExceptionCode = exceptionCode;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getExceptionDetail() {
		return ExceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		ExceptionDetail = exceptionDetail;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getParams() {
		return Params;
	}
	public void setParams(String params) {
		Params = params;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getRequestIp() {
		return RequestIp;
	}
	public void setRequestIp(String requestIp) {
		RequestIp = requestIp;
	}
	
	
}
