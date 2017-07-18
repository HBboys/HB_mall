package com.hbboys.app.service.impl;

import java.util.List;

import com.hbboys.app.dao.GoodDao;
import com.hbboys.app.domain.Good;
import com.hbboys.app.service.GoodService;
import com.hbboys.app.vo.GoodPage;

public class GoodServiceImpl implements GoodService{
	private GoodDao goodDao;
	
	public void setBookDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	@Override
	public void newgood(Good good) {
		// TODO Auto-generated method stub
		goodDao.newgood(good);
	}

	@Override
	public void deletegood(int gid) {
		// TODO Auto-generated method stub
		goodDao.deletegood(gid);
	}

	@Override
	public void editgood(Good good) {
		// TODO Auto-generated method stub
		goodDao.editgood(good);
	}

	@Override
	public GoodPage myallgood(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		GoodPage goodPage = new GoodPage();
		List<Good> list = goodDao.myallgood(currentPage, pageSize);
		goodPage.setDataList(list);
		goodPage.setCurrentPage(currentPage);
		goodPage.setPageSize(pageSize);
		int totalCount = goodDao.mygoodcount();
		goodPage.setTotalCount(totalCount);
		goodPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return goodPage;
	}

	@Override
	public Good findbyid(int gid) {
		// TODO Auto-generated method stub
		return goodDao.findbyid(gid);
	}

}
