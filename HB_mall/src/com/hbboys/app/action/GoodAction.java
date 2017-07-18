package com.hbboys.app.action;

import org.apache.struts2.ServletActionContext;
import com.hbboys.app.domain.Good;
import com.hbboys.app.service.GoodService;
import com.hbboys.app.vo.GoodPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodAction extends ActionSupport implements ModelDriven<Good>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Good good=new Good();
	private GoodService goodService;
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

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	
	public String newgood() {
		goodService.newgood(good);
		return "good_search";
	}
	
	public String deletegood() {
		goodService.deletegood(good.getGid());
		return "good_search";
	}
	
	public String editgood() {
		goodService.editgood(good);
		return "good_search";
	}
	
	public String search() {
		GoodPage goodPage=goodService.myallgood(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("bookPage", goodPage);
		return SUCCESS;
	}
	@Override
	public Good getModel() {
		// TODO Auto-generated method stub
		return good;
	}

}
