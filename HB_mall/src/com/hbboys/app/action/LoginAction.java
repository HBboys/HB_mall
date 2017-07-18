package com.hbboys.app.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbboys.app.util.HibernateUtil;
import com.hbboys.app.domain.User;
import com.hbboys.app.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user=new User();
	@Autowired
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String login() {
		Session session = HibernateUtil.openSession();
		Transaction tran = session.beginTransaction();
		Query query  = session.createQuery("from User where username = ? and password = ?");
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		HttpSession session2=ServletActionContext.getRequest().getSession();
		session2.setAttribute("uid", user.getUid());
		@SuppressWarnings("unchecked")
		List<User> list =query.list();
		tran.commit();
		session.close();
		if(!list.isEmpty()){
			return SUCCESS;
		}else{
			this.addActionError("用户名或密码错误");
			return "fail";
		}	
	}
	
	public String register() {
		userService.register(user);
		return SUCCESS;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
