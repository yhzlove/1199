package com.y.entity;




/**
 * user实体表
 */
public class UserFormMap {
	private String id;
	private String userName;
	private String accountName;
	private String password ;
	private String credentialsSalt;
	private String description;
	private String locked;
	private String createTime;
	private String deletestatus;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCredentialsSalt() {
		return credentialsSalt;
	}
	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}
	
	

}
