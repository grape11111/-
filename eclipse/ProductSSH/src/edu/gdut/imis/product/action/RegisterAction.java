package edu.gdut.imis.product.action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.ProductEBI;
import edu.gdut.imis.product.business.ebi.UsersEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Users;

public class RegisterAction {
	private Users user;
	private UsersEBI registerEbi;
	
	
	public UsersEBI getRegisterEbi() {
		return registerEbi;
	}
	public void setRegisterEbi(UsersEBI registerEbi) {
		this.registerEbi = registerEbi;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}


	public String register() {
//		if((EBOFactory.getUsersEBO().loginChu(user.getuNickname(), user.getuPassword()))==null){
//			if(EBOFactory.getUsersEBO().register(user)==true) {
		if(registerEbi.loginChu(user.getuNickname(), user.getuPassword())==null) {
			if(registerEbi.register(user)==true) {
				return "success";
			}
		}
		return "fail";
	}
	public String alter() {
//		if(EBOFactory.getUsersEBO().update(user)==true) {
		if(registerEbi.update(user)==true) {
			ActionContext context=ActionContext.getContext();
			context.getSession().put("user",user);
			return "uMessage";
		}
		return "fail";
	}
}
