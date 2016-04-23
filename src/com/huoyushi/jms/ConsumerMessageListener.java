package com.huoyushi.jms;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.huoyushi.MyOrderServer.DAO.MenuManagerDAO;
import com.huoyushi.MyOrderServer.DAO.OrderManagerDAO;
import com.huoyushi.MyOrderServer.DAO.UserManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Seller;

 
public class ConsumerMessageListener implements MessageListener {
	
	@Autowired(required=true)
	OrderManagerDAO orderManagerDAO;
	@Autowired(required=true)
	UserManagerDAO userManagerDAO;
	@Autowired(required=true)
	MenuManagerDAO menuManagerDAO;
    public void onMessage(Message message) {
    	System.out.println(message.getClass());
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
    	ObjectMessage objMsg = (ObjectMessage) message;
    	Order order=new Order();
		try {
			
			order= (Order) objMsg.getObject();
			Seller seller=userManagerDAO.findSellerbyID(order.getSeller().getSellerid());
			seller.getOrders().add(order);
			order.setSeller(seller);
			
			Customer customer=userManagerDAO.finCustomerbyID(order.getCustomer().getCustomerid());
			customer.getOrders().add(order);
			order.setCustomer(customer);
			System.out.println("消息内容是：" + order.getSeller().getSellerid());
			
			  orderManagerDAO.addOrder(order);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ///System.out.println("接收到一个纯文本消息。");
        
    }
 
}