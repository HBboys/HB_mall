package com.hbboys.app.service;

import com.hbboys.app.domain.Order;
import com.hbboys.app.vo.OrderPage;

public interface OrderService {
	public void makeorder(Order order);
	
	public void cancelorder(int orderid);
	
	public OrderPage myallorder(int currentPage,int pageSize);
}
