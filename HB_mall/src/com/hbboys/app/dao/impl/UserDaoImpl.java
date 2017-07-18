package com.hbboys.app.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hbboys.app.dao.UserDao;
import com.hbboys.app.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	
}
