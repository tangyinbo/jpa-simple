package cn.edu.jpa.manytoone2way;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_orderitem")
public class OrderItem {
	private int id;
	private float price;
	private Order order;

	/**
	 * @return order
	 * 
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, optional = false)
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            要设置的 order
	 */

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return id
	 */
	@Id
	@GeneratedValue
	@Column(name = "oi_id")
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return price
	 */
	@Column(name = "oi_price", length = 12, nullable = false)
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            要设置的 price
	 */

	public void setPrice(float price) {
		this.price = price;
	}

}
