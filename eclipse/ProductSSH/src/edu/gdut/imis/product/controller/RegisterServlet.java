package edu.gdut.imis.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Users;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		Users user=new Users();
		String uNickname=req.getParameter("uNickname");
		user.setuNickname(uNickname);
		user.setuName(req.getParameter("uName"));
		user.setuSex(req.getParameter("uSex"));
		user.setuPassword(req.getParameter("uPassword"));
		user.setuPhone(req.getParameter("uPhone"));
		user.setuAddress(req.getParameter("uAddress"));
		if((EBOFactory.getUsersEBO().loginChu(req.getParameter("uNickname"), req.getParameter("uPassword")))==null){
			if(EBOFactory.getUsersEBO().register(user)==true) {
				resp.sendRedirect("Login.jsp");
			}
		}
		
	}

}
