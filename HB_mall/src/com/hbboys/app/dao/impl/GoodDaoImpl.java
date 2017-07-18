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

import com.hbboys.app.dao.GoodDao;
import com.hbboys.app.domain.Good;

public class GoodDaoImpl extends HibernateDaoSupport implements GoodDao{

	@Override
	public void newgood(Good good) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(good);
	}

	@Override
	public void deletegood(int gid) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.findbyid(gid));
	}

	@Override
	public void editgood(Good good) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(good);
	}

	@Override
	public List<Good> myallgood(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Good> list = this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				HttpSession session2=ServletActionContext.getRequest().getSession();
				int uid=(int) session2.getAttribute("uid");
				Query query  = session.createQuery("from Good where sellerid=?");
				query.setInteger(0, uid);
				query.setFirstResult(currentPage);
				query.setMaxResults(pageSize);
				List<Good> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public Good findbyid(int gid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Good.class, gid);
	}

	@Override
	public int mygoodcount() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Object> list = this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				HttpSession session2=ServletActionContext.getRequest().getSession();
				int uid=(int) session2.getAttribute("uid");
				Query query  = session.createQuery("from Good where sellerid=?");
				query.setInteger(0, uid);
				List<Object> list = query.list();
				return list;
			}
		});
		Long count=(Long) list.listIterator().next();
		return count.intValue();
	}

}
