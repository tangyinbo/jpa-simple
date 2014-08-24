package cn.edu.jpa.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_role")
public class Role {
	private int id;
	private String roleName;
	private Set<Permission> privs;
	
	public void addPriv(Permission priv){
		if(priv==null)return;
		privs.add(priv);
	}
	
	public void unCorrectionPriv(Permission priv){
		this.privs.remove(priv);
	}
	
	/** 
	 * @return privs 
	 */
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="roles")
	public Set<Permission> getPrivs() {
		return privs;
	}
	/** 
	 * @param privs 要设置的 privs 
	 */
	
	public void setPrivs(Set<Permission> privs) {
		this.privs = privs;
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
	 * @return roleName 
	 */
	@Column(name="role_name",length=20)
	public String getRoleName() {
		return roleName;
	}
	/** 
	 * @param roleName 要设置的 roleName 
	 */
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
