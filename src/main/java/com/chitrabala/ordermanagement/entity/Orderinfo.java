package com.chitrabala.ordermanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "orderinfo")
public class Orderinfo {

	@Id
	@Column(name = "orderinfo_id")
	@GeneratedValue
	private long orderinfo_id;
	
	private Date order_date;
	
	private Date delivery_date;
	
	private String garland_type;
	
	private int no_of_pcs;
	
	private int no_of_gms;
	
	private long finalized_price;
	
	private long advance_amount;
	
	private long remaining_amount;
	
	private boolean is_completed;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_cust_id")
//	private Customer customer;

	public Orderinfo() {
		
	}
	
	public Orderinfo(long id, Date order_date, Date delivery_date, String garland_type, int no_of_pcs, int no_of_gms,
			long finalized_price, long advance_amount, long remaining_amount, boolean isCompleted) {
		super();
		this.orderinfo_id = id;
		this.order_date = order_date;
		this.delivery_date = delivery_date;
		this.garland_type = garland_type;
		this.no_of_pcs = no_of_pcs;
		this.no_of_gms = no_of_gms;
		this.finalized_price = finalized_price;
		this.advance_amount = advance_amount;
		this.remaining_amount = remaining_amount;
		this.is_completed = isCompleted;
	}
	
	public long getOrder_id() {
		return orderinfo_id;
	}
	
	public void setOrder_id(long order_id) {
		this.orderinfo_id = order_id;
	}
	
	public Date getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	public Date getDelivery_date() {
		return delivery_date;
	}
	
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	
	public String getGarland_type() {
		return garland_type;
	}
	
	public void setGarland_type(String garland_type) {
		this.garland_type = garland_type;
	}
	
	public int getNo_of_pcs() {
		return no_of_pcs;
	}
	
	public void setNo_of_pcs(int no_of_pcs) {
		this.no_of_pcs = no_of_pcs;
	}
	
	public int getNo_of_gms() {
		return no_of_gms;
	}
	
	public void setNo_of_gms(int no_of_gms) {
		this.no_of_gms = no_of_gms;
	}
	
	public long getFinalized_price() {
		return finalized_price;
	}
	
	public void setFinalized_price(long finalized_price) {
		this.finalized_price = finalized_price;
	}
	
	public long getAdvance_amount() {
		return advance_amount;
	}
	
	public void setAdvance_amount(long advance_amount) {
		this.advance_amount = advance_amount;
	}
	
	public long getRemaining_amount() {
		return remaining_amount;
	}
	
	public void setRemaining_amount(long remaining_amount) {
		this.remaining_amount = remaining_amount;
	}
	
	public boolean isCompleted() {
		return is_completed;
	}
	
	public void setCompleted(boolean isCompleted) {
		this.is_completed = isCompleted;
	}

}
