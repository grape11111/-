package edu.gdut.imis.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.gdut.imis.product.common.DBConnector;
import edu.gdut.imis.product.common.HbnUtil;
import edu.gdut.imis.product.dao.dai.UsersDAI;
import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Style;
import edu.gdut.imis.product.entity.Users;

public class UsersDAO implements UsersDAI {
	 private SessionFactory sessionFactory;
	  
		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Users loginChu(String name, String password) {
		Users user=new Users();
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("uName", name));
		criteria.add(Restrictions.eq("uPassword", password));
		List<Users>list =criteria.list();
		if(list.isEmpty()) {
			return null;
		}else {
			user=list.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return user;
	}


	public List<Users> findAll() {
		String hql="from Users";
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Users>list =session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}


	@Override
	public boolean register(Users user) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}


	@Override
	public boolean freeze(int status, String uID) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		Users user=session.load(Users.class, uID);
		user.setStatus(status);
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}


	@Override
	public boolean update(Users user) {
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
