package cn.edu.jpa.compositepk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
/**
 * 
* @ClassName: CompositePK
* @Description: 联合主键必须实现序列化接口,必须重写hashcode equals 方法
* @author Tangyinbo
* @date 2014-8-24 下午5:43:08
*
 */
@Embeddable
public class CompositePK implements Serializable{
	
	/**
	* @Fields serialVersionUID : TODO
	*/
	
	private static final long serialVersionUID = 5125713828827031241L;

	private int no;
	

	private String name;

	/* (非 Javadoc) 
	* <p>Title: hashCode</p> 
	* <p>Description: </p> 
	* @return 
	* @see java.lang.Object#hashCode() 
	*/ 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: equals</p> 
	* <p>Description: </p> 
	* @param obj
	* @return 
	* @see java.lang.Object#equals(java.lang.Object) 
	*/ 
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositePK other = (CompositePK) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		return true;
	}

	/** 
	 * @return no 
	 */
	@Column(name="s_no",nullable=false)
	public int getNo() {
		return no;
	}

	/** 
	 * @param no 要设置的 no 
	 */
	
	public void setNo(int no) {
		this.no = no;
	}

	/** 
	 * @return name 
	 */
	@Column(name="s_name",length=20,nullable=false)
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
