package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String orderid;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customerid")
	Customer customer;
	@OneToOne
	@JoinColumn(name="sellerid")
	Seller seller;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="order",cascade=CascadeType.ALL)
	private Set<Order_Menu>ordermenus=new HashSet<>();
	int flag;
	public Order() {
		super();
	}

  

	public Order(String orderid, Customer customer, Seller seller, Set<Order_Menu> ordermenus, int flag) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.seller = seller;
		this.ordermenus = ordermenus;
		this.flag = flag;
	}
	 @JsonIgnore
	public Set<Order_Menu> getOrdermenus() {
		return ordermenus;
	}
  
	public void setOrdermenus(Set<Order_Menu> ordermenus) {
		this.ordermenus = ordermenus;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
   
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "{\"orderid\":\"" + orderid + "\",\"customer\":" + customer.toString() + ",\"flag\":\"" + flag + "\"}";
	}
	
	
}
