package edu.gdut.imis.product.business.ebo;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.business.ebi.ProductEBI;
import edu.gdut.imis.product.dao.dai.IBaseDAO;
import edu.gdut.imis.product.dao.factory.DAOFactory;
import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Users;


public class ProductEBO implements ProductEBI {
//通过接口调用
	private IBaseDAO bdao;
	
	public IBaseDAO getBdao() {
		return bdao;
	}

	public void setBdao(IBaseDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public boolean create(ProductModel pm) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.create(pm);
	}

	@Override
	public boolean delete(String code) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.delete(code);
	}

	@Override
	public boolean update(ProductModel pm) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.update(pm);
	}

	@Override
	public List<ProductModel> findAll() {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		List<ProductModel>list=bdao.findAll();
		return list;
	}

	@Override
	public List<ProductModel> findBystyle(String style) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.findBystyle(style);
	}

	@Override
	public void sortByStyle() {
		// TODO Auto-generated method stub
	}

	@Override
	public ProductModel findByCode(String code) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.findByCode(code);
	}

	@Override
	public List<ProductModel> findByCondition(Map<String, String> condition) {
		//IBaseDAO bdao=DAOFactory.getProductDAO();
		return bdao.findByCondition(condition);
	}


}
