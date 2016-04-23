package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="menus")
public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuid;
	@ManyToOne
	@JoinColumn(name="sellerid")
	Seller seller;
	float price;
	String mname;
	String description;
	String pic;
	public Menu() {
		// TODO Auto-generated constructor stub
	}


	public Menu(Integer menuid, Seller seller, float price, String mname, String description, String pic) {
		super();
		this.menuid = menuid;
		this.seller = seller;
		this.price = price;
		this.mname = mname;
		this.description = description;
		this.pic = pic;
		
	}


	public Integer getMenuid() {
		return menuid;
	}


	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}


	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "{\"menuid\":\"" + menuid + "\",\"price\":\"" + price + "\",\"mname\":\"" + mname + "\",\"description\":\""
				+ description + "\",\"pic\":\"" + pic + "\"}";
	}
	
}
