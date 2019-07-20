package edu.gdut.imis.product.dao.dai;

import java.util.List;
import java.util.Map;

import edu.gdut.imis.product.entity.Cartproduct;
import edu.gdut.imis.product.entity.Order;

public interface CartDAI {

	//��ӵ����ﳵ�ļ�¼
	Cartproduct add(String uID,String code);
	List<Cartproduct> findAll(String uID);
	//ɾ��һ�����ﳵ��¼
	boolean delete(String uID,String code);
	//��չ��ﳵ
	boolean deleteAll(String uID);
	
	//���ɶ���
	boolean createOrder(String uID, String orderID,String datetime,Map<String,Integer>map);	
	//��ѯ���û����ж���
	List<Order> findAllOrder(String uID);
	//֧������
	boolean pay(String orderID);
	//ɾ������
	boolean deleteOrder(String orderID);
	
	//����Աִ�ж���
	boolean checkOrder(String orderID);
	//��ѯ����ƽ̨�Ķ���
	List<Order> findAllOrder();
	//ͨ��������Ų�ѯ������ϸ��Ϣ
	Order  findByOrderID(String orderID,String uID);
}
