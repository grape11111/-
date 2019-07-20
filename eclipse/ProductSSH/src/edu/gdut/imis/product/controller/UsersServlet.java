package edu.gdut.imis.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Users;

public class UsersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		String submitFlag=req.getParameter("submitFlag");
		if(("findAllusers").equals(submitFlag)) {
			List<Users>list=EBOFactory.getUsersEBO().findAll();
			req.getSession().setAttribute("userlist", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Jsp/BackStage/UsersMessage.jsp");
			dispatcher.forward(req, resp);			
		}else {
			int status=Integer.parseInt(req.getParameter("status"));
			String uID=req.getParameter("uID");
			if(EBOFactory.getUsersEBO().freeze(status, uID)==true) {
				List<Users>list=EBOFactory.getUsersEBO().findAll();
				req.getSession().setAttribute("userlist", list);
				resp.sendRedirect("Jsp/BackStage/UsersMessage.jsp");
			}
		}
		
	}
	
}
