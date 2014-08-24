package cn.edu.jpa.onetoone;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import cn.edu.jpa.base.BasicTest;

public class OneToOneTest extends BasicTest{
	private EntityManager manager;
	@Before
	public void setUp(){
		manager = factory.createEntityManager();
	}
	@Test
	public void test1(){
		System.out.println("----------");
	}
}
