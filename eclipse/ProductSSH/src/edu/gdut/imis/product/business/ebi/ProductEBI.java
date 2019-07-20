package edu.gdut.imis.product.business.ebi;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;



public interface ProductEBI {
	boolean create(ProductModel pm);
	boolean delete(String Code);
	boolean update(ProductModel pm);
	
	List<ProductModel>findAll();
	List<ProductModel>findBystyle(String style);
	ProductModel findByCode(String code);
	void sortByStyle();
	List<ProductModel>findByCondition(Map<String,String>condition);
}
