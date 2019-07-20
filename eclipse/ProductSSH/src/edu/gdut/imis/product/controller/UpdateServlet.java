package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
//用户信息修改
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		
		Users user=new Users();
		user.setuID(req.getParameter("uID"));
		String uNickname=req.getParameter("uNickname");
		user.setuNickname(uNickname);
		user.setuName(req.getParameter("uName"));
		user.setuSex(req.getParameter("uSex"));
		user.setuPassword(req.getParameter("uPassword"));
		user.setuPhone(req.getParameter("uPhone"));
		user.setuAddress(req.getParameter("uAddress"));
		if(EBOFactory.getUsersEBO().update(user)==true) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("Jsp/Front/uMessage.jsp");
		}
	}
	
}
