package edu.gdut.imis.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.gdut.imis.product.common.DBConnector;
import edu.gdut.imis.product.common.HbnUtil;
import edu.gdut.imis.product.dao.dai.IBaseDAO;
import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Style;
import edu.gdut.imis.product.entity.Users;


public class ProductDAO implements IBaseDAO {

 private SessionFactory sessionFactory;
  
	public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	@Override
	public boolean create(ProductModel pm) {
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		session.beginTransaction();
		session.save(pm);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(String code) {
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		ProductModel pm=session.load(ProductModel.class, code);
		session.beginTransaction();
		session.delete(pm);
		session.getTransaction().commit();
		session.close();
		return true;
	}


	@Override
	public boolean update(ProductModel pm) {
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		session.beginTransaction();
		session.update(pm);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<ProductModel> findAll() {
		String hql="from ProductModel";
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		session.beginTransaction();
		List<ProductModel>list =session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	//通过商品条码或商品名称查询商品信息
	public List<ProductModel> findBystyle(String style) {
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("style", Style.valueOf(style)));
		List<ProductModel>list =criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
//通过商品条码查询商品信息
	public ProductModel findByCode(String code) {
		Session session=sessionFactory.openSession();
		//Session session=HbnUtil.getSession();
		ProductModel pm=session.load(ProductModel.class, code);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		return pm;
	}

	@Override
	public List<ProductModel> findByCondition(Map<String, String> condition) {
		Session session=sessionFactory.openSession();
		//Session session =HbnUtil.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(ProductModel.class);
		Iterator<Entry<String,String>> iter=condition.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String>entry=iter.next();
			String key=entry.getKey();
			String value=entry.getValue();
			if("code".equals(key)) {
				criteria.add(Restrictions.like("code", value,MatchMode.ANYWHERE));
			}
			if("name".equals(key)) {
				criteria.add(Restrictions.like("name", value,MatchMode.ANYWHERE));
			}
			if("style".equals(key)) {
				criteria.add(Restrictions.eq("style", Style.valueOf(value)));
			}
			if("pricegt".equals(key)) {
				criteria.add(Restrictions.gt("price", Float.valueOf(value)));
			}
			if("pricelt".equals(key)) {
				criteria.add(Restrictions.lt("price", Float.valueOf(value)));
			}			
		}
		List<ProductModel>list =criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
}
	
