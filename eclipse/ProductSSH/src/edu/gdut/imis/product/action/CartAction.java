package edu.gdut.imis.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import edu.gdut.imis.product.business.ebi.CartEBI;
import edu.gdut.imis.product.business.factory.EBOFactory;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.*;

public class CartAction {
	private String uID;
	private String code;
	private CartEBI cartEbi;
	

	public CartEBI getCartEbi() {
		return cartEbi;
	}

	public void setCartEbi(CartEBI cartEbi) {
		this.cartEbi = cartEbi;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
//        ActionContext context=ActionContext.getContext();
//		Users user=(Users) context.getSession().get("user");	
	public String findAll() {	
		//List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
		   ActionContext context=ActionContext.getContext();
			Users user=(Users) context.getSession().get("user");
		List<Cartproduct> list=cartEbi.findAll(user.getuID());
		context.getSession().put("cartMap", list);
		return "success";
	}
	public String add() {
//		Cartproduct cartproduct=EBOFactory.getCartEBO().add(user.getuID(), code);
//		List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
		   ActionContext context=ActionContext.getContext();
			Users user=(Users) context.getSession().get("user");
		Cartproduct cartproduct=cartEbi.add(user.getuID(),code);
		List<Cartproduct> list=cartEbi.findAll(user.getuID());
		context.getSession().put("cartMap", list);
		return "success";
	}
	public String delete() {
//		EBOFactory.getCartEBO().delete(user.getuID(), code);
//		List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
		ActionContext context=ActionContext.getContext();
		Users user=(Users) context.getSession().get("user");
		cartEbi.delete(user.getuID(),code);
		List<Cartproduct> list=cartEbi.findAll(user.getuID());
		context.getSession().put("cartMap", list);
		return "success";
	}
	public String deleteAll() {
//		EBOFactory.getCartEBO().deleteAll(user.getuID());
//		List<Cartproduct> list=EBOFactory.getCartEBO().findAll(user.getuID());
		ActionContext context=ActionContext.getContext();
	    Users user=(Users) context.getSession().get("user");
		cartEbi.deleteAll(user.getuID());
		List<Cartproduct> list=cartEbi.findAll(user.getuID());
		context.getSession().put("cartMap", list);
		return "success";
	}
}
