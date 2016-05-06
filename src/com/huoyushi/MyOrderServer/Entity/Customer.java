package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="customers")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String customerid;
	private String uname;
	private String psd;
	private String email;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer",fetch=FetchType.EAGER)
	private List<Order>orders=new ArrayList<>();
	public Customer() {
		super();
	}
    public Customer(String customerid, String uname, String psd, String email, List<Order> orders) {
		super();
		this.customerid = customerid;
		this.uname = uname;
		this.psd = psd;
		this.email = email;
		this.orders = orders;
	}



	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "{\"customerid\":\"" + customerid + "\",\"uname\":\"" + uname + "\",\"psd\":\"" + psd + "\",\"email\":\""
				+ email + "\"}";
	}
	
	
}