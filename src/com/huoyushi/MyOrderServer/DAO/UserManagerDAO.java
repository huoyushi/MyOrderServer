package com.huoyushi.MyOrderServer.DAO;

import java.util.List;

import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;

public interface UserManagerDAO {
	public boolean addCustomer(Customer customer);
	public boolean addSeller(Seller seller);
	public Seller findSeller(String id,String psd);
	public Customer findCustomer(String id,String psd);
	public List<Seller>findSellerlist();
	boolean authorize(String sellerid);
	public Seller findSellerbyID(String id);
	public Customer finCustomerbyID(String id);
}
