package com.hbboys.app.dao;

import java.util.List;

import com.hbboys.app.domain.Good;

public interface GoodDao {
	
	public void newgood(Good good);
	
	public void deletegood(int gid);
	
	public void editgood(Good good);
	
	public List<Good> myallgood(int currentPage,int pageSize);
	
	public Good findbyid(int gid);
	
	public int mygoodcount();
}
