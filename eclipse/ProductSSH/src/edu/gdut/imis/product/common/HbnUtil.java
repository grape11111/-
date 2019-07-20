package edu.gdut.imis.product.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtil {
	private static SessionFactory sessionFactory;
	public static Session getSession() {
		if((sessionFactory==null)||(sessionFactory.isClosed())){
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory.openSession();
	}
	
}
