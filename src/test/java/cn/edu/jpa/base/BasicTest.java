package cn.edu.jpa.base;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;


public class BasicTest {
	protected static EntityManagerFactory factory;
	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("---------");
		factory = Persistence.createEntityManagerFactory("test1");
	}
}
