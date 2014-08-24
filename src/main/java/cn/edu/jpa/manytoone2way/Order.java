package cn.edu.jpa.manytoone2way;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {
	private int id;
	private String ordreName;
	private float orderPrice;
	private Set<OrderItem> orderItems;

	/**
	 * @return id
	 */

	@Id
	@GeneratedValue
	@Column(name = "o_id")
	public int getId() {
		return id;
	}

	/**
	 * fetchType 以Many结尾的默认的lazy 以one 结尾的默认的是EAger(立刻加载)
	 * 
	 * @return orderItem
	 */
	@OneToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.MERGE }, mappedBy = "order", fetch = FetchType.LAZY)
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems
	 *            要设置的 orderItems
	 */

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void removeItem(Object item){
		if(item==null)return;
		if(item instanceof Set){
			this.orderItems.remove(item);
		}else{
			if(this.orderItems.contains(item)){
				this.orderItems.remove(item);
			}
		}
			
	}
	/**
	 * @param id
	 *            要设置的 id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return ordreName
	 */
	@Column(name = "o_name", length = 20, nullable = false)
	public String getOrdreName() {
		return ordreName;
	}

	/**
	 * @param ordreName
	 *            要设置的 ordreName
	 */

	public void setOrdreName(String ordreName) {
		this.ordreName = ordreName;
	}

	/**
	 * @return orderPrice
	 */

	@Column(name = "o_price", length = 12, nullable = false)
	public float getOrderPrice() {
		return orderPrice;
	}

	/**
	 * @param orderPrice
	 *            要设置的 orderPrice
	 */

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

}
