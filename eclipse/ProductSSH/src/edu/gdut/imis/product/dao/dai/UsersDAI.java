package edu.gdut.imis.product.dao.dai;

import java.util.List;

import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public interface UsersDAI {
	//注册
	boolean register(Users user);
	//冻结、解冻用户
	boolean  freeze(int status,String uID);
	//修改用户信息
	boolean update(Users user);
	
	//登录验证
	Users loginChu(String name,String password);
	//查询所有用户
	List<Users> findAll();
}
