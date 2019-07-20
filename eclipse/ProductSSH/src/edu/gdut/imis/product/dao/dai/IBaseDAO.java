package edu.gdut.imis.product.dao.dai;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;

public interface IBaseDAO {
	boolean create(ProductModel pm);
	boolean delete(String code);
	boolean update(ProductModel pm);
	//��ѯ������Ʒ��Ϣ
	List<ProductModel>findAll();
	//ͨ����Ʒ���������Ʒ���Ʋ�����Ʒ��Ϣ
	List<ProductModel>findBystyle(String style);
	//ͨ����Ʒ���������Ʒ
	ProductModel findByCode(String code);
	
	List<ProductModel>findByCondition(Map <String,String>condition);
}
