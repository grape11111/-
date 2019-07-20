package edu.gdut.imis.product.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.gdut.imis.product.entity.ProductModel;
import edu.gdut.imis.product.entity.Style;



public class DBConnector {
	public static Connection getConn() throws SQLException {
//		String url="jdbc:mysql://localhost:3306/commodity?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
//		String user="root";
//		String password="123456";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Connection conn=DriverManager.getConnection(url, user, password);
Connection conn=null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds;
			ds = (DataSource)envCtx.lookup("jdbc/ProductDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;
	}
	
	/*public List<ProductModel> findAll() {
		Connection conn=null;
		Statement stmt=null;
		List<ProductModel>list=new ArrayList<ProductModel>();
		ProductModel pm=null;
		try {
			conn =this.getConn();
			String sql="SELECT* FROM product";
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				pm=new ProductModel();
				pm.setCode(rs.getString(1));
				pm.setName(rs.getString(2));
				pm.setStyle(Style.valueOf(rs.getString(3)));
				pm.setPrice(rs.getFloat(4));
				list.add(pm);
			}
		} catch (SQLException e) {
			System.out.println("数据库加载失败！");
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("数据库加载失败！2");
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<ProductModel> find(String codename) {
		Connection conn=null;
		Statement stmt=null;
		List<ProductModel>list=new ArrayList<ProductModel>();
		ProductModel pm=null;
		try {
			conn =DBConnector.getConn();
			String sql="SELECT* FROM product WHERE code='"+codename+"' or name='"+codename+"' ;";
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				pm=new ProductModel();
				pm.setCode(rs.getString(1));
				pm.setName(rs.getString(2));
				Style st=Style.valueOf(rs.getString(3));
				pm.setStyle(st);
				pm.setPrice(rs.getFloat(4));
				list.add(pm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return list;
	}
public static void main(String[]args) {
	DBConnector db=new DBConnector();
	System.out.println("book表");
	List<ProductModel>list=db.find("短袖");
//	String code=list.get(0).getCode();
//	System.out.println(isbn);
	if(list.size()==0) {
		System.out.println("没有数据");
	}else {
	System.out.println("youshuju");
	String isbn=list.get(0).getCode();
	System.out.println(isbn);
	}
}*/

}
