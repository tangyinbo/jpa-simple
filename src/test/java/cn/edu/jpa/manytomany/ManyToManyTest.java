package cn.edu.jpa.manytomany;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.edu.jpa.base.BasicTest;

public class ManyToManyTest extends BasicTest{
	public EntityManager entityManager;
	@Before
	public void setUp(){
		entityManager = factory.createEntityManager();
	}
	@After
	public void tearDown(){
		entityManager.close();
	}
	
	@Test
	public void testInit(){
		System.out.println("----------");
	}
	@Test
	public void insertPermission(){
		Permission priv  = new Permission();
		priv.setUrl("/system/role");
		entityManager.getTransaction().begin();
		entityManager.persist(priv);
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void insertRole(){
		Role role  = new Role();
		role.setRoleName("系統管理員2");
		entityManager.getTransaction().begin();
		entityManager.persist(role);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * 
	* @Title: correctionRolePriv 
	* @Description: 关系维护方维护主键
	* @param    
	* @return void  
	* @author Tangyinbo   
	* @date 2014-8-24 下午5:15:44
	* @throws
	 */
	@Test
	public void correctionRolePriv(){
		entityManager.getTransaction().begin();
		Role role =entityManager.getReference(Role.class, 2);
		Permission priv = entityManager.getReference(Permission.class, 1);
		priv.addRole(role);
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void unCorrectionRolePriv(){
		entityManager.getTransaction().begin();
		Role role =entityManager.getReference(Role.class, 1);
		Permission priv = entityManager.getReference(Permission.class, 1);
		priv.unCorrectionRole(role);
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void queryRole(){
		Role role =entityManager.getReference(Role.class, 2);
		System.out.println("------------------");
		System.out.println(role.getRoleName());
		Set<Permission> privs = role.getPrivs();
		System.out.println(privs.size());
		for(Iterator<Permission> iterator=privs.iterator();iterator.hasNext();){
			Permission priv = iterator.next();
			System.out.println(priv.getUrl());
		}
		System.out.println("------------------");
	}
	
	@Test
	public void queryPriv(){
		Permission priv =entityManager.getReference(Permission.class, 1);
		System.out.println("------------------");
		Set<Role> roles = priv.getRoles();
		System.out.println(roles.size());
		for(Iterator<Role> iterator=roles.iterator();iterator.hasNext();){
			Role role = iterator.next();
			System.out.println(role.getRoleName());
		}
		System.out.println("------------------");
	}
	
}
