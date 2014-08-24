package cn.edu.jpa.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
@Table(name="t_person")
public class Person {
	private int id;
	private String name;
	private int age;
	private Date birthday;
	private Gender gender;
	//大文本可以用 @lob  二进制文件也可以用@lob
	private String resume;
	//如果我们从数据库中获取记录的信息的时候,file对象很大, 为了不浪费内存,我们可以设置file 懒加载   @Basic(fetch=FetchType.LAZY)
	private byte[] file;
	//如果我们这个po对象的某个字段不需要在数据库映射  @Transient
	private String temp;
	/**
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="p_id")
	public int getId() {
		return id;
	}

	/** 
	 * @return temp 
	 */
	@Transient
	public String getTemp() {
		return temp;
	}

	/** 
	 * @param temp 要设置的 temp 
	 */
	
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/** 
	 * @return resume 
	 */
	@Lob
	@Column(name="p_resume")
	public String getResume() {
		return resume;
	}

	/** 
	 * @param resume 要设置的 resume 
	 */
	
	public void setResume(String resume) {
		this.resume = resume;
	}

	/** 
	 * @return file 
	 */
	@Lob
	@Column(name="p_file")
	@Basic(fetch=FetchType.LAZY)
	public byte[] getFile() {
		return file;
	}

	/** 
	 * @param file 要设置的 file 
	 */
	
	public void setFile(byte[] file) {
		this.file = file;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	@Column(name="p_name",length=20)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * @return age 
	 */
	
	public int getAge() {
		return age;
	}

	/** 
	 * @param age 要设置的 age 
	 */
	
	@Column(name="p_age")
	public void setAge(int age) {
		this.age = age;
	}

	/** 
	 * @return birthday 
	 */
	@Column(name="p_birthday")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBirthday() {
		return birthday;
	}

	/** 
	 * @param birthday 要设置的 birthday 
	 */
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/** 
	 * @return gender 
	 */
	
	@Column(name="p_sex",length=6)
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	/** 
	 * @param gender 要设置的 gender 
	 */
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
