package com.huoyushi.MyOrderServer.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Seller;
@Controller
public class OrderManagerController {
	private Order order;
	
	public Order getOrder(HttpServletRequest request){
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		if(order==null){
			order = new Order();
			order.setCustomer(customer);
		}
		return order;
	}
	
	
}
