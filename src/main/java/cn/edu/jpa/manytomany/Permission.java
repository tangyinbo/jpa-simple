package cn.edu.jpa.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_priv")
public class Permission {
	private int id;
	private String url;
	private Set<Role> roles;
	public void addRole(Role role){
		this.roles.add(role);
	}
	
	public void unCorrectionRole(Role role){
		if(role==null)return;
		this.roles.remove(role);
	}
	
	/** 
	 * @return roles 
	 */
	@ManyToMany(cascade=CascadeType.REFRESH)
	@JoinTable(name="t_role_priv",inverseJoinColumns={@JoinColumn(name="role_id")},joinColumns={@JoinColumn(name="priv_id")})
	public Set<Role> getRoles() {
		return roles;
	}
	/** 
	 * @param roles 要设置的 roles 
	 */
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	 * @return url 
	 */
	@Column(name="P_url",length=100)
	public String getUrl() {
		return url;
	}
	/** 
	 * @param url 要设置的 url 
	 */
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}
