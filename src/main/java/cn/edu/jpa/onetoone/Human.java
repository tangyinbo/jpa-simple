package cn.edu.jpa.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.junit.ClassRule;

@Entity
@Table(name="t_human")
public class Human {
	private int id;
	private String name;
	private IdCard idCard;
	
	/** 
	 * @return idCard 
	 */
	@OneToOne(cascade={CascadeType.REFRESH,CascadeType.REMOVE},optional=false)
	@JoinColumn(name="card_id")
	public IdCard getIdCard() {
		return idCard;
	}
	/** 
	 * @param idCard 要设置的 idCard 
	 */
	
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
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
	 * @return name 
	 */
	@Column(name="h_name",length=20,nullable=false)
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
