package com.huoyushi.MyOrderServer.DAO;

import java.util.List;

import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;


public interface OrderManagerDAO {
	public String addOrder(Order order);
	public List<Order> getorderlist(String sellrid,int flag);
	public boolean setorderFlag(String orderid);
	public boolean getorderflag(String orderid);
	public List<Menu>getorderdetails(String orderid);
}
