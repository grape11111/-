package edu.gdut.imis.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.UsersEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Users;

public class UsersAction {
	private int status;
	private String uID;
	private UsersEBI usersEbi;
	
	
	public UsersEBI getUsersEbi() {
		return usersEbi;
	}
	public void setUsersEbi(UsersEBI usersEbi) {
		this.usersEbi = usersEbi;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	
	public String findAllusers() {
		//List<Users>list=EBOFactory.getUsersEBO().findAll();
		List<Users>list=usersEbi.findAll();
		ActionContext context=ActionContext.getContext();
		context.getSession().put("userlist", list);
		return "success";
	}
	public String freeze() {
//		if(EBOFactory.getUsersEBO().freeze(status, uID)==true) {
//			List<Users>list=EBOFactory.getUsersEBO().findAll();
		if(usersEbi.freeze(status, uID)==true) {
			List<Users>list=usersEbi.findAll();
			ActionContext context=ActionContext.getContext();
			context.getSession().put("userlist", list);
			return "success";
	    }
		return "fail";
    }
}
