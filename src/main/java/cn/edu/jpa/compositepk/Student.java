package cn.edu.jpa.compositepk;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	private CompositePK pk;
	
	private String age;

	/** 
	 * @return pk 
	 */
	@EmbeddedId
	public CompositePK getPk() {
		return pk;
	}

	/** 
	 * @param pk 要设置的 pk 
	 */
	
	public void setPk(CompositePK pk) {
		this.pk = pk;
	}

	/** 
	 * @return age 
	 */
	@Column(name="s_age",nullable=false)
	public String getAge() {
		return age;
	}

	/** 
	 * @param age 要设置的 age 
	 */
	
	public void setAge(String age) {
		this.age = age;
	}
	
}
