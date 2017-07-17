package com.hbboys.app.domain;
// Generated 2017-7-17 18:43:57 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Good generated by hbm2java
 */
public class Good implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gid;
	private User user;
	private String gname;
	private Integer price;
	private Integer count;
	private Date timeonshelf;
	private String category;
	private Set<Order> orders = new HashSet<Order>(0);

	public Good() {
	}

	public Good(int gid) {
		this.gid = gid;
	}

	public Good(int gid, User user, String gname, Integer price, Integer count, Date timeonshelf, String category,
			Set<Order> orders) {
		this.gid = gid;
		this.user = user;
		this.gname = gname;
		this.price = price;
		this.count = count;
		this.timeonshelf = timeonshelf;
		this.category = category;
		this.orders = orders;
	}

	public int getGid() {
		return this.gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getTimeonshelf() {
		return this.timeonshelf;
	}

	public void setTimeonshelf(Date timeonshelf) {
		this.timeonshelf = timeonshelf;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}