package cn.edu.jpa.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest{
	private static EntityManagerFactory entityManagerFactory;
	@BeforeClass
	public static void setUpClass(){
		entityManagerFactory=Persistence.createEntityManagerFactory("test1");
		
	}
	private EntityManager entityManager;
	@Before
	public void setUp(){
		entityManager=  entityManagerFactory.createEntityManager();
	}
	@After
	public void tearDown(){
		entityManager.close();
	}
	@Test
	public void test1(){
		Person p= new Person();
		p.setName("tangyinbo");
		p.setBirthday(new Date());
		p.setGender(Gender.FEMALE);
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(p);
		transaction.commit();
		entityManager.close();
	}
	
	@Test
	public void testGetPerson(){
		Person p=entityManager.find(Person.class, 1);
		System.out.println(p.getName());
	}
}
