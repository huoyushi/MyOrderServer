package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private String id;
	@OneToOne
	@JoinColumn(name="customerid")
	Customer customer;
	@OneToOne
	@JoinColumn(name="sellerid")
	Seller seller;
	@OneToMany
	List<Menu>menus=new ArrayList<>();
	int flag;
	
	
	public Order() {
		super();
	}

	public Order(String id, Customer customer, Seller seller, List<Menu> menus, int flag) {
		super();
		this.id = id;
		this.customer = customer;
		this.seller = seller;
		this.menus = menus;
		this.flag = flag;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
    @JsonIgnore
   
     public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
