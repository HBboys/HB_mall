package com.hbboys.app.service.impl;

import java.util.List;

import com.hbboys.app.dao.OrderDao;
import com.hbboys.app.domain.Order;
import com.hbboys.app.service.OrderService;
import com.hbboys.app.vo.OrderPage;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void makeorder(Order order) {
		// TODO Auto-generated method stub
		orderDao.makeorder(order);
	}

	@Override
	public void cancelorder(int orderid) {
		// TODO Auto-generated method stub
		orderDao.cancelorder(orderid);
	}

	@Override
	public OrderPage myallorder(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		OrderPage orderPage = new OrderPage();
		List<Order> list = orderDao.myallorder(currentPage, pageSize);
		orderPage.setDataList(list);
		orderPage.setCurrentPage(currentPage);
		orderPage.setPageSize(pageSize);
		int totalCount = orderDao.myordercount();
		orderPage.setTotalCount(totalCount);
		orderPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return orderPage;
	}
	
}
