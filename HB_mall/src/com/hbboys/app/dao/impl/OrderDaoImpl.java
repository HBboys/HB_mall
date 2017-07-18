package com.hbboys.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hbboys.app.dao.OrderDao;
import com.hbboys.app.domain.Order;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{

	@Override
	public void makeorder(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(order);
	}

	@Override
	public void cancelorder(int orderid) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.findbyid(orderid));
	}

	@Override
	public List<Order> myallorder(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Order> list = this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				HttpSession session2=ServletActionContext.getRequest().getSession();
				int uid=(int) session2.getAttribute("uid");
				Query query  = session.createQuery("from Order where buyerid=?");
				query.setInteger(0, uid);
				query.setFirstResult(currentPage);
				query.setMaxResults(pageSize);
				List<Order> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public Order findbyid(int orderid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class, orderid);
	}

	@Override
	public int myordercount() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Object> list = this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				HttpSession session2=ServletActionContext.getRequest().getSession();
				int uid=(int) session2.getAttribute("uid");
				Query query  = session.createQuery("from Order where buyerid=?");
				query.setInteger(0, uid);
				List<Object> list = query.list();
				return list;
			}
		});
		Long count=(Long) list.listIterator().next();
		return count.intValue();
	}

}
