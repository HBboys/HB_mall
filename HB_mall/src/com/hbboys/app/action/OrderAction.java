package com.hbboys.app.action;

import com.hbboys.app.domain.Order;
import com.hbboys.app.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order order=new Order();
	private OrderService orderService;
	private int currentPage=1;
	private int pageSize=5;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String makeorder() {
		orderService.makeorder(order);
		return "success";
	}
	
	public String cancelorder() {
		orderService.cancelorder(order.getOrderid());
		return "success";
	}
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
}
