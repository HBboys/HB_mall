package com.hbboys.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbboys.app.dao.UserDao;
import com.hbboys.app.domain.User;
import com.hbboys.app.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}


	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}

	
	
}
