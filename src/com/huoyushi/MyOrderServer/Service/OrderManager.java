package com.huoyushi.MyOrderServer.Service;

import java.util.List;

import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;

public interface OrderManager {
	public String SendOrder(Order order);
	public List<Order> getOrderlist(String sellrid,int flag);
	public boolean setOrderFlag(String orderid);
	public boolean getOrderFlag(String orderid);
	public List<Menu>orderdetails(String orderid);
}
