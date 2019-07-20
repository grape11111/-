package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public class LoginCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		if(role.equals("admin")) {
			Admin admin=EBOFactory.getAdminEBO().loginCha(name, password);
			HttpSession session=req.getSession();
			session.setAttribute("admin", admin);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/frame.jsp");
			dispatcher.forward(req, resp);
		}else if(role.equals("users")){
			Users user=EBOFactory.getUsersEBO().loginChu(name, password);
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			//resp.sendRedirect("Jsp/Front/frame_users.jsp");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/Front/frame_users.jsp");
			dispatcher.forward(req, resp);
		}else if(role==null){
			resp.sendRedirect("Login.jsp");
		}
	}		
}
