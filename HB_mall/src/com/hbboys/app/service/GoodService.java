package com.hbboys.app.service;

import com.hbboys.app.domain.Good;
import com.hbboys.app.vo.GoodPage;

public interface GoodService {
	
	public void newgood(Good good);
	
	public void deletegood(int gid);
	
	public void editgood(Good good);
	
	public GoodPage myallgood(int currentPage,int pageSize);
	
	public Good findbyid(int gid);
	
}
