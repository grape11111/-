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
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import edu.gdut.imis.product.common.DBConnector;
import edu.gdut.imis.product.common.HbnUtil;
import edu.gdut.imis.product.dao.dai.CartDAI;
import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;
import edu.gdut.imis.product.entity.Orderproduct;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Style;
import edu.gdut.imis.product.entity.Users;

public class CartDAO implements CartDAI {
	 private SessionFactory sessionFactory;
	  
		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Cartproduct add(String uID, String code) {
		Cartproduct cp=new Cartproduct();
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Cartproduct.class);
		criteria.add(Restrictions.eq("uID", uID));
		criteria.add(Restrictions.eq("code", code));
		List<Cartproduct>list =criteria.list();
		if(list.isEmpty()) {				
				cp.setuID(uID);
				cp.setCode(code);
				cp.setCount(1);
				session.save(cp);
		}else {
				cp=list.get(0);
				cp.setCount(cp.getCount()+1);
				session.update(cp);
			}
		session.getTransaction().commit();
		session.close();
		return cp;	
	}

	@Override
	public List<Cartproduct> findAll(String uID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Cartproduct.class);
		criteria.add(Restrictions.eq("uID", uID));
		List<Cartproduct>list =criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public boolean delete(String uID, String code) {
		Cartproduct cp=new Cartproduct();
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Cartproduct.class);
		criteria.add(Restrictions.eq("uID", uID));
		criteria.add(Restrictions.eq("code", code));
		List<Cartproduct>list =criteria.list();
		if(list.isEmpty()) {				
				return false;
		}else {
			cp=list.get(0);
			session.delete(cp);
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteAll(String uID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql = "delete from Cartproduct t where t.uID=:uid";
		Query query=session.createQuery(hql);
		query.setString("uid", uID);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	@Override
	public boolean createOrder(String uID, String orderID, String datetime, Map<String, Integer> map) {
		//插入记录到 订单-商品信息表（订单编号、商品id、数量）
		//删除购物车相应的记录
		//插入订单记录到订单信息表  createOrder(String uID, String OrderNumber,String datetime,Map<String,Integer>map);
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Order order=new Order();
		order.setOrderID(orderID);
		order.setuID(uID);
		order.setDatetime(datetime);
		session.save(order);
		
		Iterator<Entry<String,Integer>> iter1=map.entrySet().iterator();
		while(iter1.hasNext()) {
			Orderproduct op=new Orderproduct();
			Map.Entry<String, Integer>entry=iter1.next();
			String code=entry.getKey();
			int count=entry.getValue();
			op.setOrderID(orderID);
			op.setCode(code);
			op.setCount(count);
			session.save(op);
		}
		
		String hql = "delete from Cartproduct t where t.uID=:uid and t.code=:cd";
		Query query=session.createQuery(hql);
		query.setString("uid", uID);
		
		Iterator<Entry<String,Integer>> iter2=map.entrySet().iterator();
		while(iter2.hasNext()) {
			Map.Entry<String, Integer>entry=iter2.next();
			String key=entry.getKey();
			query.setString("cd", key);
			query.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Order> findAllOrder(String uID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("uID", uID));
		List<Order>list =criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public boolean pay(String orderID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		Order order=session.load(Order.class, orderID);
		session.beginTransaction();
		order.setStatus(1);
		session.update(order);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteOrder(String orderID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		//Order order=session.load(Order.class, orderID);
		session.beginTransaction();
		//session.delete(order);
		//先删除子表，再删除主表
		String hql1= "delete from orderproduct op where op.orderID=:orID";
		Query query1=session.createQuery(hql1);
		query1.setString("orID", orderID);
		query1.executeUpdate();
		String hql = "delete from order or where or.orderID=:oi";
		Query query=session.createQuery(hql);
		query.setString("oi", orderID);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean checkOrder(String orderID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		Order order=session.load(Order.class, orderID);
		session.beginTransaction();
		order.setResult(1);
		session.update(order);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Order> findAllOrder() {
		String hql="from Order";
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Order>list =session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public Order  findByOrderID(String orderID,String uID) {
		Order order=new Order();
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("uID", uID));
		criteria.add(Restrictions.eq("orderID", orderID));
		List<Order>list =criteria.list();
		order=list.get(0);
		session.getTransaction().commit();
		session.close();
		return order;			
	}		
}
