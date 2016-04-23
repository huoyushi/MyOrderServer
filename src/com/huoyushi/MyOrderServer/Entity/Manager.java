package com.huoyushi.MyOrderServer.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String uname;
	private String psd;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String id, String uname, String psd) {
		super();
		this.id = id;
		this.uname = uname;
		this.psd = psd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
}
