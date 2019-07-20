package edu.gdut.imis.product.business.ebo;

import edu.gdut.imis.product.business.ebi.AdminEBI;
import edu.gdut.imis.product.dao.dai.AdminDAI;
import edu.gdut.imis.product.dao.dai.CartDAI;
import edu.gdut.imis.product.dao.factory.DAOFactory;
import edu.gdut.imis.product.entity.Admin;

public class AdminEBO implements AdminEBI {
	private AdminDAI bdao;
	
	public AdminDAI getBdao() {
		return bdao;
	}

	public void setBdao(AdminDAI bdao) {
		this.bdao = bdao;
	}

	@Override
	public Admin loginCha(String name, String password) {
		// TODO Auto-generated method stub
		//return DAOFactory.getAdminDAO().loginCha(name, password);
		return bdao.loginCha(name, password);
	}

}
