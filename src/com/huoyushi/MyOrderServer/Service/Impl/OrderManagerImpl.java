package com.huoyushi.MyOrderServer.Service.Impl;

import java.util.List;

import javax.jms.Destination;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huoyushi.MyOrderServer.DAO.MenuManagerDAO;
import com.huoyushi.MyOrderServer.DAO.OrderManagerDAO;
import com.huoyushi.MyOrderServer.DAO.UserManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Seller;
import com.huoyushi.MyOrderServer.Service.OrderManager;
import com.huoyushi.jms.OrderProducer;
import com.huoyushi.util.UUIDUtil;
@Service("OrderManagerService")
public class OrderManagerImpl implements OrderManager{
	  @Autowired  
	  @Qualifier("orderDestination") 
		    private Destination destination;
	  @Autowired(required=true)
	  OrderProducer producer;
	  @Autowired(required=true)
		OrderManagerDAO orderManagerDAO;
		@Autowired(required=true)
		UserManagerDAO userManagerDAO;
		@Autowired(required=true)
		MenuManagerDAO menuManagerDAO;
	@Override
	@Transactional
	public String SendOrder(Order orderin) {
		Order order=orderin;
		order.setFlag(0);
		String id=UUIDUtil.generateuuid();
		System.out.println(id);
		order.setId(id);
		
		Seller seller=userManagerDAO.findSellerbyID(order.getSeller().getSellerid());
		seller.getOrders().add(order);
		order.setSeller(seller);
		
		Customer customer=userManagerDAO.finCustomerbyID(order.getCustomer().getCustomerid());
		customer.getOrders().add(order);
		order.setCustomer(customer);
		//producer.sendMessage(destination, order);
		// TODO Auto-generated method stub
		return orderManagerDAO.addOrder(order);
		
	}
	@Override
	public List<Order> getOrderlist(String sellrid,int flag) {
		return orderManagerDAO.getorderlist(sellrid, flag);
	}
	@Override
	@Transactional
	public boolean setOrderFlag(String orderid) {
		return orderManagerDAO.setorderFlag(orderid);
	}
	@Override
	public boolean getOrderFlag(String orderid) {
		// TODO Auto-generated method stub
		return orderManagerDAO.getorderflag(orderid);
	}
	@Override
	public List<Menu> orderdetails(String orderid) {
		// TODO Auto-generated method stub
		return orderManagerDAO.getorderdetails(orderid);
	}

}
