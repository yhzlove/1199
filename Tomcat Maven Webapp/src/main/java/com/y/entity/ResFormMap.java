package com.y.entity;




/**
 * 菜单实体表
 */

public class ResFormMap {
		
//	private String  id;
	private String  name;
//	private String  parentId;
	private String  parentName;
	private String  resKey;
	private String  type;
	private String  resUrl;
//	private String  level;
	private String  icon;
//	private String  ishide;
	private String  description;
	private Integer id;
	private Integer parentId;
	private Integer level;
	private Integer ishide;
	private Integer isRes;//
	
	
	public Integer getIsRes() {
		return isRes;
	}
	public void setIsRes(Integer isRes) {
		this.isRes = isRes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getResKey() {
		return resKey;
	}
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getIshide() {
		return ishide;
	}
	public void setIshide(Integer ishide) {
		this.ishide = ishide;
	}
	
	
	
	
	
	
	
	
	
	
}
