package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf8");
		String code=req.getParameter("code");
		if(code!=null) {
		ProductModel pm=EBOFactory.getProductEBO().findByCode(code);
		}		
		HttpSession session=req.getSession();
		Users user=(Users)session.getAttribute("user");
		String submitFlag=req.getParameter("submitFlag");
		if(submitFlag.equals("add")) {
			Cartproduct cartproduct=EBOFactory.getCartEBO().add(user.getuID(), code);
		}else if(submitFlag.equals("delete")) {
			EBOFactory.getCartEBO().delete(user.getuID(), code);
		}else if(submitFlag.equals("deleteAll")) {
			EBOFactory.getCartEBO().deleteAll(user.getuID());
		}
		List<Cartproduct>cartMap=EBOFactory.getCartEBO().findAll(user.getuID());
		session.setAttribute("cartMap", cartMap);
		RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/Front/cart.jsp");
		dispatcher.forward(req, resp);
	}

}
