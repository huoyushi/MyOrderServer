package com.huoyushi.MyOrderServer.Entity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.util.Base64;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.mail.util.BASE64EncoderStream;

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
	@Transient
	String  pic;
	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(columnDefinition="BLOB")
	private byte[] picblob; 
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	

	public Menu(Integer menuid, Seller seller, float price, String mname, String description, String pic,
			byte[] picblob) {
		super();
		this.menuid = menuid;
		this.seller = seller;
		this.price = price;
		this.mname = mname;
		this.description = description;
		this.pic = pic;
		this.picblob = picblob;
	}

	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}

   @JsonIgnore
	public byte[] getPicblob() {
		return picblob;
	}

   @JsonIgnore
	public void setPicblob(byte[] picblob) {
		this.picblob = picblob;
	}


	public Integer getMenuid() {
		return menuid;
	}


	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
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
	@SuppressWarnings("restriction")
	public String byte2String(){
		return new sun.misc.BASE64Encoder().encode(this.picblob);
	}
	public void string2byte() throws IOException{
		 this.picblob=new sun.misc.BASE64Decoder().decodeBuffer(this.pic);
	} 
	@Override
	public String toString() {
		return "{\"menuid\":\"" + menuid + "\",\"price\":\"" + price + "\",\"mname\":\"" + mname
				+ "\",\"description\":\"" + description + "\",\"pic\":\"" + byte2String() + "\"}";
	}
	
}
