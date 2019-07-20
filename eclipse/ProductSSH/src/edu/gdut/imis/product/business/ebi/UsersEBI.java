package edu.gdut.imis.product.business.ebi;

import java.util.List;

import edu.gdut.imis.product.entity.Users;

public interface UsersEBI {
	boolean register(Users user);
	boolean  freeze(int status,String uID);
	boolean update(Users user);
	Users loginChu(String name, String password);
	List<Users> findAll();
}
