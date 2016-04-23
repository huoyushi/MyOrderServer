package com.huoyushi.MyOrderServer.Service;

import java.util.List;

import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;

public interface UserManager {
	public Object login(String id,String psd,int groupid);
	public String registerCustomer(Customer customer);
	public String registerSeller(Seller seller);
	public List<Seller> getpendinglist();
	public List<Seller> getSellers();
	public boolean authorize(String sellerid);
}
