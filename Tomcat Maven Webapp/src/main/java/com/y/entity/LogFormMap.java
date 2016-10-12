package com.y.entity;

public class LogFormMap {
	
//	logForm.put("accountName",user);
//	logForm.put("module",map.get("module"));
//	logForm.put("methods","<font color=\"red\">执行方法异常:-->"+map.get("methods")+"</font>");
//	logForm.put("description","<font color=\"red\">执行方法异常:-->"+e+"</font>");
//	logForm.put("actionTime","0");
//	logForm.put("userIP",ip);
	private String id;  			//ID
	private String accountName;  	//用户名
	private String module;			//模块
	private String methods;			//方法
	private String description;		//描述
	private String actionTime;		//执行方法所消耗的时间
	private String userIP;			//用户IP地址
	private String operTime;
	
	
	
	
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMethods() {
		return methods;
	}
	public void setMethods(String methods) {
		this.methods = methods;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActionTime() {
		return actionTime;
	}
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	
	
	
	
}
