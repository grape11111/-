package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;


public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code=req.getParameter("code");
		ProductModel pm=EBOFactory.getProductEBO().findByCode(code);
		Cookie cookie=null;
		HttpSession session=req.getSession();
		Users user=(Users) session.getAttribute("user");
		if(user!=null) {
			String id=user.getuID();
			 cookie=new Cookie(id+"product"+code,pm.getName());
		}else {
			 cookie=new Cookie("product"+code,pm.getName());
		}
		cookie.setMaxAge(1*24*60*60);
		resp.addCookie(cookie);
		resp.setContentType("text/html;charset=utf8");
		Cookie[] allCookies=req.getCookies();
		
		req.setAttribute("productmodel",pm);
		RequestDispatcher dispatcher=req.getRequestDispatcher("detail.jsp");
		dispatcher.forward(req, resp);
	}

}

