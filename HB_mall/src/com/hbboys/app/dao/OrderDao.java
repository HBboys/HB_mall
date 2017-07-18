package com.hbboys.app.dao;

import java.util.List;

import com.hbboys.app.domain.Order;

public interface OrderDao {
	public void makeorder(Order order);
	
	public void cancelorder(int orderid);
	
	public List<Order> myallorder(int currentPage,int pageSize);
	
	public Order findbyid(int orderid);
	
	public int myordercount();
}
