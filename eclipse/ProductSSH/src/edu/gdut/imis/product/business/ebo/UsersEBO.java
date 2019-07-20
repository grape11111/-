package edu.gdut.imis.product.business.ebo;

import java.util.List;

import edu.gdut.imis.product.business.ebi.UsersEBI;
import edu.gdut.imis.product.dao.dai.IBaseDAO;
import edu.gdut.imis.product.dao.dai.UsersDAI;
import edu.gdut.imis.product.dao.factory.DAOFactory;
import edu.gdut.imis.product.entity.Users;

public class UsersEBO implements UsersEBI {
	
	private UsersDAI udai;
	
	
	public UsersDAI getUdai() {
		return udai;
	}
	public void setUdai(UsersDAI udai) {
		this.udai = udai;
	}
	public Users loginChu(String name, String password) {
		//UsersDAI udai=DAOFactory.getUsersDAO();
		return udai.loginChu(name, password);
	}
	public List<Users> findAll(){
		//UsersDAI udai=DAOFactory.getUsersDAO();
		return udai.findAll();
	}
	public boolean register(Users user){
		//UsersDAI udai=DAOFactory.getUsersDAO();
		return udai.register(user);
	}
	@Override
	public boolean freeze(int status, String uID) {
		//UsersDAI udai=DAOFactory.getUsersDAO();
		return udai.freeze(status, uID);
	}
	@Override
	public boolean update(Users user) {
		//UsersDAI udai=DAOFactory.getUsersDAO();
		return udai.update(user);
	}
}
