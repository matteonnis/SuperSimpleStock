/**
 * 
 */
package it.jpmorgan.model;

import java.math.BigDecimal;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 *
 */
public class Trade {

	private int id;
	private int type;
	private BigDecimal quantity;
	private BigDecimal price;
	private long time;
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
