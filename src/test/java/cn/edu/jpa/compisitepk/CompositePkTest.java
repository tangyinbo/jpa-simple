package cn.edu.jpa.compisitepk;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.edu.jpa.base.BasicTest;

public class CompositePkTest extends BasicTest{
	private EntityManager entityManager;
	@Before
	public void setUp(){
		entityManager = factory.createEntityManager();
	}
	@After
	public void tearDown(){
		entityManager.close();
	}
	
	@Test
	public void testinit(){
		System.out.println("---------");
	}
}
