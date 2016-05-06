package com.huoyushi.MyOrderServer.DAO;

import java.util.List;
import java.util.Set;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Order_Menu;


public interface OrderManagerDAO {
	public String addOrder(Order order);
	public List<Order> getorderlist(String sellrid,int flag);
	public boolean setorderFlag(String orderid);
	public boolean getorderflag(String orderid);
	public Set<Order_Menu>getorderdetails(String orderid);
}
