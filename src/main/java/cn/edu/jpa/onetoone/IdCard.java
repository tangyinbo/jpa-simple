package cn.edu.jpa.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_idcard")
public class IdCard {
	private int id;
	private String no;
	private Human human;
	
	/** 
	 * @return human 
	 */
	@OneToOne(cascade={CascadeType.REFRESH},mappedBy="idCard")
	public Human getHuman() {
		return human;
	}
	/** 
	 * @param human 要设置的 human 
	 */
	
	public void setHuman(Human human) {
		this.human = human;
	}
	/** 
	 * @return id 
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/** 
	 * @param id 要设置的 id 
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	/** 
	 * @return no 
	 */
	@Column(name="no",length=18,nullable=false)
	public String getNo() {
		return no;
	}
	/** 
	 * @param no 要设置的 no 
	 */
	
	public void setNo(String no) {
		this.no = no;
	}
	
}
