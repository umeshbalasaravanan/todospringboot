package com.chitrabala.ordermanagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "cust_id")
    @GeneratedValue
	private long cust_id;
	private String name;
	private String address;
	private String phone_no;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id")
	private Orderinfo orderinfo;
	
	
	public Customer() {
		
	}

	public Customer(long cust_id, String name, String address, String phone_no, Orderinfo orderinfo) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
		this.phone_no = phone_no;
		this.orderinfo = orderinfo;
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public Orderinfo getOrder() {
		return orderinfo;
	}

	public void setOrder(Orderinfo order) {
		this.orderinfo = order;
	}
	
}
