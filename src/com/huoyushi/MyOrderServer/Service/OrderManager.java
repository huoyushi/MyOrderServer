package com.huoyushi.MyOrderServer.Service;

import java.util.List;
import java.util.Set;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Order_Menu;

public interface OrderManager {
	public String SendOrder(Order order);
	public List<Order> getOrderlist(String sellrid,int flag);
	public boolean setOrderFlag(String orderid);
	public boolean getOrderFlag(String orderid);
	public Set<Order_Menu> orderdetails(String orderid);
}
