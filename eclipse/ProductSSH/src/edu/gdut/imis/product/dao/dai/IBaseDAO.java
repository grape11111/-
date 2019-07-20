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
	//查询所有商品信息
	List<ProductModel>findAll();
	//通过商品条码或者商品名称查找商品信息
	List<ProductModel>findBystyle(String style);
	//通过商品条码查找商品
	ProductModel findByCode(String code);
	
	List<ProductModel>findByCondition(Map <String,String>condition);
}
