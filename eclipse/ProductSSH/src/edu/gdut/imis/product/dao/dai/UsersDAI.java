package edu.gdut.imis.product.dao.dai;

import java.util.List;

import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public interface UsersDAI {
	//ע��
	boolean register(Users user);
	//���ᡢ�ⶳ�û�
	boolean  freeze(int status,String uID);
	//�޸��û���Ϣ
	boolean update(Users user);
	
	//��¼��֤
	Users loginChu(String name,String password);
	//��ѯ�����û�
	List<Users> findAll();
}
