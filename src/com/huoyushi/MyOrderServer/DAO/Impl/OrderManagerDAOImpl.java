package com.huoyushi.MyOrderServer.DAO.Impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;



import org.springframework.stereotype.Repository;


import com.huoyushi.MyOrderServer.DAO.OrderManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Seller;

@Repository("OrderManagerDAO")
public class OrderManagerDAOImpl implements OrderManagerDAO{
	@PersistenceContext(name="persitentunit")
	private EntityManager em;
	@Override
	public String addOrder(Order order) {
		System.out.println(order.getCustomer().getCustomerid());
		em.persist(order);
		return order.getId();
	}

	@Override
	public List<Order> getorderlist(String sellrid,int flag) {
		Seller seller=em.find(Seller.class, sellrid);
		String jpql="select order from  Order order where order.seller=:seller and order.flag=:flag";
	    
		 List<Order> orderlist=em.createQuery(jpql)
					.setParameter("seller", seller)
					.setParameter("flag",flag)
					.getResultList();
			if(orderlist.isEmpty()) return null;
			for (Order order : orderlist) {
				Customer customer=em.find(Customer.class, order.getCustomer().getCustomerid());
				order.setCustomer(customer);	
			}
			return orderlist;
	}

	@Override
	public boolean setorderFlag(String orderid) {
		Order order=em.find(Order.class, orderid);
		try {
			order.setFlag(1);
			if(order.getFlag()==1)
			return true;
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean getorderflag(String orderid) {
	
		Order order=em.find(Order.class, orderid);
		try {
			if(order.getFlag()==1)
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;	
	}

	@Override
	public List<Menu> getorderdetails(String orderid) {
	
		Order order=em.find(Order.class, orderid);
		if(order!=null){
			System.out.println("here");
			System.out.println(order.getCustomer().getCustomerid());
			List<Menu>menus=order.getMenus();
			if(menus!=null)
			{
			for (Menu menu : menus) {
				System.out.println(menu.getMname());
				
			}
			}
			return order.getMenus();
		
	}
		return null;
	}

}
