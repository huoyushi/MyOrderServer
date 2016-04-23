package com.huoyushi.Axis2Proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.regex.REUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Service.OrderManager;
import com.huoyushi.util.JsonUtil;
import com.huoyushi.util.SerializeTools;

public class OrderManagerAxisProxy {
	OrderManager orderManager;

	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	public String getOrderlist(String sellrid,int flag) throws JsonParseException, JsonMappingException, IOException{
		if(orderManager.getOrderlist(sellrid, 0)==null)
			return "empty";
		String string=SerializeTools.list2Json(orderManager.getOrderlist(sellrid, 0), 2);
		return string;
	}
	public String sendOrder(String order ,String menus) throws JsonParseException, JsonMappingException, IOException{
		System.out.println(order);
		System.out.println(menus);
		List<Menu> menus2=SerializeTools.fromListJson(menus, Menu.class);
		for (Menu menu : menus2) {
			System.out.println(menu.getMenuid());
		}
		Order order2=SerializeTools.json2Object(order, Order.class);
		order2.setFlag(0);
		order2.setMenus(menus2);
		System.out.println(order2.getCustomer().getCustomerid()+"dd"+order2.getSeller().getSellerid());
		return orderManager.SendOrder(order2);
	}
	public String getOrderFlag(String orderid){
		if(orderManager.getOrderFlag(orderid))
		return "yes";
		return "no";
	}
	public String setOrderFlag(String orderid){
		if(orderManager.setOrderFlag(orderid))
			return "yes";
		return "no";
	}
	public String getOrderdetails(String orderid) throws JsonParseException, JsonMappingException, IOException{
		if(orderManager.orderdetails(orderid)==null)
			return "error";
		return SerializeTools.list2Json(orderManager.orderdetails(orderid),3);
	}

}
