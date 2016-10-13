package com.y.dao;

import java.util.List;

import com.y.entity.ResFormMap;


public interface ResourcesMapper  {
	public List<ResFormMap> findChildlists(ResFormMap map);

	public List<ResFormMap> findRes(ResFormMap map);

	public void updateSortOrder(List<ResFormMap> map);
	
	public List<ResFormMap> findUserResourcess(String userId);

	public List<ResFormMap> findByWhere(ResFormMap resFormMap);

	public List<ResFormMap> getAllRes();
	
}
