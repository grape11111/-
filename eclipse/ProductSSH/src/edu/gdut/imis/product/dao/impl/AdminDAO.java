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
import org.hibernate.criterion.Restrictions;

import edu.gdut.imis.product.common.DBConnector;
import edu.gdut.imis.product.common.HbnUtil;
import edu.gdut.imis.product.dao.dai.AdminDAI;
import edu.gdut.imis.product.entity.Admin;
import edu.gdut.imis.product.entity.Users;

public class AdminDAO implements AdminDAI{
	 private SessionFactory sessionFactory;
	  
		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Admin loginCha(String name, String password) {
		Admin admin=new Admin();
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("aName", name));
		criteria.add(Restrictions.eq("aPassword", password));
		List<Admin>list =criteria.list();
		if(list.isEmpty()) {
			return null;
		}else {
			admin=list.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return admin;	
	}

	public List<Admin> findAlladmin() {
		String hql="from admins";
		//Session session=HbnUtil.getSession();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Admin>list =session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
