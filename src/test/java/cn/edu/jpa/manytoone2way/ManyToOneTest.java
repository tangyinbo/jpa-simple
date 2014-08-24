package cn.edu.jpa.manytoone2way;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import cn.edu.jpa.base.BasicTest;

public class ManyToOneTest extends BasicTest{
	private EntityManager manager;
	@Before
	public void setUp(){
		manager = factory.createEntityManager();
	}
	@After
	public void tearDown(){
		manager.close();
	}
	
	@Test
	public void testInsertOrder(){
		Order order = new Order();
		order.setOrdreName("order1");
		order.setOrderPrice(12.5f);
		manager.getTransaction().begin();
		manager.persist(order);
		manager.getTransaction().commit();
	}
	
	@Test
	public void testInsertOrderItem(){
		OrderItem item  = new OrderItem();
		item.setPrice(12f);
		Order order =manager.getReference(Order.class, 1);
		manager.getTransaction().begin();
		item.setOrder(order);
		manager.persist(item);
		manager.getTransaction().commit();
	}
	
	
	/**
	 * 
	* @Title: testDelteOrder 
	* @Description: 移除关联关系的被维护放,必须先接触和主键维护方的关系
	* @param    
	* @return void  
	* @author Tangyinbo   
	* @date 2014-8-24 上午11:34:38
	* @throws
	 */
	@Test
	public void testDelteOrder(){
		manager.getTransaction().begin();
		Order order = manager.getReference(Order.class, 1);
		order.removeItem(order.getOrderItems());
		manager.remove(order);
		manager.getTransaction().commit();
	}
}
