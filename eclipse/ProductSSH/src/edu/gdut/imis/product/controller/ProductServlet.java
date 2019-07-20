package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.common.PageBean;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Style;


public class ProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		String submitFlag=req.getParameter("submitFlag");
		//查询所有商品信息
		if("Find".equals(submitFlag)) {
				this.display(req, resp);
		}
		
		//条件查询
		if("query".equals(submitFlag)) {
			Map<String,String>condition=new HashMap<String,String>();
			Enumeration<String>paramNames=req.getParameterNames();
			while(paramNames.hasMoreElements()) {
				String key=paramNames.nextElement();
				String value=req.getParameter(key);
				if(value!=null&&value.trim().length()!=0) {
					condition.put(key, value);
				}
			}
			List<ProductModel>list=EBOFactory.getProductEBO().findByCondition(condition);
			if(list==null) {
				list=new ArrayList<ProductModel>();				
			}
			req.setAttribute("result", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("list.jsp");
			dispatcher.forward(req, resp);
		}
		
		if("findAllproduct".equals(submitFlag)) {
			List<ProductModel>list=EBOFactory.getProductEBO().findAll();
			if(list==null) {
				list=new ArrayList<ProductModel>();				
			}
			PageBean pb=new PageBean();
			pb.setPageSize(5);
			pb.setCurrPage(0);
			pb.setTotalPage(list.size()/pb.getPageSize()+1);
			if(list.size()<=5) {
				 pb.setPagelist(list);
			}else {
				 pb.setPagelist(list.subList(0, 1*pb.getPageSize()-1));
			}
			req.getSession().setAttribute("pb", pb);
			req.getSession().setAttribute("result", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/list.jsp");
			dispatcher.forward(req, resp);
		}
		
		if("uquery".equals(submitFlag)) {
			Map<String,String>condition=new HashMap<String,String>();
			Enumeration<String>paramNames=req.getParameterNames();
			while(paramNames.hasMoreElements()) {
				String key=paramNames.nextElement();
				String value=req.getParameter(key);
				if(value!=null&&value.trim().length()!=0) {
					condition.put(key, value);
				}
			}
			List<ProductModel>list=EBOFactory.getProductEBO().findByCondition(condition);
			if(list==null) {
				list=new ArrayList<ProductModel>();				
			}
			PageBean pb=new PageBean();
			pb.setPageSize(5);
			pb.setCurrPage(0);
			pb.setTotalPage(list.size()/pb.getPageSize()+1);
			if(list.size()<=5) {
				 pb.setPagelist(list);
			}else {
				 pb.setPagelist(list.subList(0, 1*pb.getPageSize()-1));
			}
			req.getSession().setAttribute("pb", pb);
			req.getSession().setAttribute("result", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/list.jsp");
			dispatcher.forward(req, resp);
		}
		
		//添加商品信息
		if("add".equals(submitFlag)) {
			resp.setContentType("text/html;charset=utf8");
			if(this.add(req)) {
				//resp.sendRedirect("Jsp/BackStage/list.jsp");
				List<ProductModel>list=EBOFactory.getProductEBO().findAll();
				if(list==null) {
					list=new ArrayList<ProductModel>();				
				}
				req.getSession().setAttribute("result", list);
				resp.sendRedirect("Jsp/BackStage/list.jsp");
			}
		}
		//删除商品信息		
		if("Delete".equals(submitFlag)) {
			String code=req.getParameter("code");
			System.out.println(code);
			EBOFactory.getProductEBO().delete(code);
			List<ProductModel>list=EBOFactory.getProductEBO().findAll();
			if(list==null) {
				list=new ArrayList<ProductModel>();				
			}
			req.getSession().setAttribute("result", list);
			resp.sendRedirect("Jsp/BackStage/list.jsp");
		}
					
		  //修改商品信息		
		if("Update".equals(submitFlag)) {
			if(this.update(req)) {
				List<ProductModel>list=EBOFactory.getProductEBO().findAll();
				if(list==null) {
					list=new ArrayList<ProductModel>();				
				}
				req.getSession().setAttribute("result", list);
				resp.sendRedirect("Jsp/BackStage/list.jsp");
			}
		}				
}
		
	private ProductModel findByCode(String code) {
		return EBOFactory.getProductEBO().findByCode(code);
	}

	private boolean update(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf8");
		ProductModel pm=new ProductModel();
		//收集请求来的数据，创建BookModel的实例，并设置其属性
		pm.setCode(req.getParameter("code"));
		pm.setName(req.getParameter("name"));
		pm.setStyle(Style.valueOf(req.getParameter("style")));
		String priceStr=req.getParameter("price");
		float price =Float.parseFloat(priceStr);
		pm.setPrice(price);
		return EBOFactory.getProductEBO().update(pm);
	}

	//通过商品条码或者商品名称查找商品信息
//	private List<ProductModel> find(HttpServletRequest req) {
//		String corename=req.getParameter("codename");
//		return EBOFactory.getProductEBO().find(corename);
//	}

	private boolean add(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf8");
		ProductModel pm=new ProductModel();
		//收集请求来的数据，创建BookModel的实例，并设置其属性
		if(this.findByCode(req.getParameter("code"))==null) {
		pm.setCode(req.getParameter("code"));
		pm.setName(req.getParameter("name"));
		pm.setStyle(Style.valueOf(req.getParameter("style")));
		String priceStr=req.getParameter("price");
		float price =Float.parseFloat(priceStr);
		pm.setPrice(price);
		return EBOFactory.getProductEBO().create(pm);
		}else {
			return false;
		}
	}
	
	private void display(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.sendRedirect("list.jsp");
	}
}