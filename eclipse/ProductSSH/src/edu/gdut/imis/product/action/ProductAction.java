package edu.gdut.imis.product.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.ProductEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.common.PageBean;
import edu.gdut.imis.product.entity.*;

public class ProductAction {
	private ProductModel pm;
	private String style;
	private ProductEBI productEbi;
	

	public ProductEBI getProductEbi() {
		return productEbi;
	}

	public void setProductEbi(ProductEBI productEbi) {
		this.productEbi = productEbi;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public ProductModel getPm() {
		return pm;
	}

	public void setPm(ProductModel pm) {
		this.pm = pm;
	}
	
	
	
	//增加商品
	public String add() {
//		EBOFactory.getProductEBO().create(pm);
//		List<ProductModel>list=EBOFactory.getProductEBO().findAll();
		pm.setCode(pm.getCode());
		if(pm.getCode()==null) {
		System.out.println("1111");}
		productEbi.create(pm);
		List<ProductModel>list=productEbi.findAll();
		this.pageHandler(list);
		return "success";
	}
	//展示所有商品
	public String display() {
		//List<ProductModel>list=EBOFactory.getProductEBO().findAll();
		List<ProductModel>list=productEbi.findAll();
		this.pageHandler(list);
		return "success";
	}
	//模糊查询
	public String query() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Map<String,String>condition=new HashMap<String,String>();
		Enumeration<String>paramNames=req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String key=paramNames.nextElement();
			String value=req.getParameter(key);
			if(value!=null&&value.trim().length()!=0) {
				condition.put(key, value);
			}
		}
		//List<ProductModel>list=EBOFactory.getProductEBO().findByCondition(condition);
		List<ProductModel>list=productEbi.findByCondition(condition);
		this.pageHandler(list);
		return "success";
	}
	
	
	//修改商品信息
	public String toUpdate() {
		//ProductModel productmodel=EBOFactory.getProductEBO().findByCode(pm.getCode());
		ProductModel productmodel =productEbi.findByCode(pm.getCode());
		ActionContext context=ActionContext.getContext();
		context.getSession().put("productmodel", productmodel);
		return "toUpdate";
	}
	public String update() {
//		if(EBOFactory.getProductEBO().update(pm)) {
//			List<ProductModel>list=EBOFactory.getProductEBO().findAll();
		if(productEbi.update(pm)) {
			List<ProductModel>list=productEbi.findAll();
			this.pageHandler(list);
			return "success";
		}
		return "fail";
	}
	//删除商品信息
	public String delete() {
//		if(EBOFactory.getProductEBO().delete(pm.getCode())) {
//			List<ProductModel>list=EBOFactory.getProductEBO().findAll();
		if(productEbi.delete(pm.getCode())) {
			List<ProductModel>list=productEbi.findAll();
			this.pageHandler(list);
			return "success";
		}
		return "fail";
	}
	
	private void pageHandler(List<ProductModel>list) {
		if(list==null) {
			list=new ArrayList<ProductModel>();
		}
		PageBean<ProductModel>pb=new PageBean<ProductModel>();
		pb.setPageSize(5);
		pb.setCurrPage(0);
		if(list.size()<pb.getPageSize()) {
			pb.setTotalPage(1);
		}else if(list.size()/pb.getPageSize()==0) {
			pb.setTotalPage(list.size()/pb.getPageSize());
		}else {
		pb.setTotalPage(list.size()/pb.getPageSize()+1);
		}
		
		ActionContext context=ActionContext.getContext();
		context.getSession().put("pb", pb);
		context.getSession().put("result", list);
	}
	
	//用户界面的商品展示
	public String displayAll() {
		//List<ProductModel>list=EBOFactory.getProductEBO().findAll();
		List<ProductModel>list=productEbi.findAll();
		ActionContext context=ActionContext.getContext();
		context.getSession().put("result", list);
		return "displayAll";
	}
	public String findByStyle() {
		//List<ProductModel>list=EBOFactory.getProductEBO().findBystyle(style);
		List<ProductModel>list=productEbi.findBystyle(style);
		ActionContext context=ActionContext.getContext();
		context.getSession().put("result", list);
		return "displayAll";
	}
	public String detail() {
		//ProductModel productmodel=EBOFactory.getProductEBO().findByCode(pm.getCode());
		ProductModel productmodel=productEbi.findByCode(pm.getCode());
		Cookie cookie=null;
		ActionContext context=ActionContext.getContext();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		Users user=(Users) session.getAttribute("user");
		if(user!=null) {
			String id=user.getuID();
			 cookie=new Cookie(id+"product"+pm.getCode(),pm.getName());
		}else {
			 cookie=new Cookie("product"+pm.getCode(),pm.getName());
		}
		cookie.setMaxAge(1*24*60*60);
		 HttpServletResponse resp = ServletActionContext.getResponse();
		resp.addCookie(cookie);
		Cookie[] allCookies=req.getCookies();
		
		context.getSession().put("productmodel",productmodel);
		return "detail";
	}
	public String uquery() {
		Map<String,String>condition=new HashMap<String,String>();
		HttpServletRequest req = ServletActionContext.getRequest();
		Enumeration<String>paramNames=req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String key=paramNames.nextElement();
			String value=req.getParameter(key);
			if(value!=null&&value.trim().length()!=0) {
				condition.put(key, value);
			}
		}
		//List<ProductModel>list=EBOFactory.getProductEBO().findByCondition(condition);
		List<ProductModel>list=productEbi.findByCondition(condition);
		ActionContext context=ActionContext.getContext();
		context.getSession().put("result", list);
		return "displayAll";
	}
}
