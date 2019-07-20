package edu.gdut.imis.product.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.AdminEBI;
import edu.gdut.imis.product.business.ebi.UsersEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.Users;

public class LoginAction {
	private String name;
	private String password;
	private String role;
	private UsersEBI usersEbi;
	private AdminEBI adminEbi;
	
	
	
	public UsersEBI getUsersEbi() {
		return usersEbi;
	}
	public void setUsersEbi(UsersEBI usersEbi) {
		this.usersEbi = usersEbi;
	}
	public AdminEBI getAdminEbi() {
		return adminEbi;
	}
	public void setAdminEbi(AdminEBI adminEbi) {
		this.adminEbi = adminEbi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String loginCh() {
		if(role.equals("admin")) {
			//Admin admin=EBOFactory.getAdminEBO().loginCha(name, password);
			Admin admin=adminEbi.loginCha(name, password);
			ActionContext context=ActionContext.getContext();
			context.getSession().put("admin", admin);
			return "login_a";
		}else if(role.equals("users")){
			//Users user=EBOFactory.getUsersEBO().loginChu(name, password);
			Users user=usersEbi.loginChu(name, password);
			ActionContext context=ActionContext.getContext();
			context.getSession().put("user", user);
			return "login_u";
		} 
			return "fail";
	}

}