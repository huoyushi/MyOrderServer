package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sellers")
public class Seller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String sellerid;
	private String uname;
	private String psd;
	private String email;
	private String identitynum;
	@OneToMany(cascade = CascadeType.ALL)
	List<Menu> menulist;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="seller")
	List<Order>orders=new ArrayList<>();
	String isauthorize;
	
	
	
	public Seller() {
		super();
	}

	public Seller(String sellerid, String uname, String psd, String email, String identitynum, List<Menu> menulist,
			List<Order> orders, String isauthorize) {
		super();
		this.sellerid= sellerid;
		this.uname = uname;
		this.psd = psd;
		this.email = email;
		this.identitynum = identitynum;
		this.menulist = menulist;
		this.orders = orders;
		this.isauthorize = isauthorize;
	}
   @JsonIgnore
	public List<Order> getList() {
		return orders;
	}

	public void setList(List<Order> orders) {
		this.orders = orders;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
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
	public String getIdentitynum() {
		return identitynum;
	}
	public void setIdentitynum(String identitynum) {
		this.identitynum = identitynum;
	}
	@JsonIgnore
	public List<Menu> getMenulist() {
		return menulist;
	}
	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
	public String getIsauthorize() {
		return isauthorize;
	}

	public void setIsauthorize(String isauthorize) {
		this.isauthorize = isauthorize;
	}

	@Override
	public String toString() {
		return "{\"sellerid\":\"" + sellerid + "\",\"uname\":\"" + uname + "\",\"psd\":\"" + psd + "\",\"email\":\"" + email
				+ "\",\"identitynum\":\"" + identitynum + "\",\"isauthorize\":\"" + isauthorize + "\"}";
	}




}
