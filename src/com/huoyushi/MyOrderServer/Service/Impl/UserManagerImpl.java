package com.huoyushi.MyOrderServer.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huoyushi.MyOrderServer.DAO.UserManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;
import com.huoyushi.MyOrderServer.Service.UserManager;
import com.huoyushi.jms.RegisterConsumer;
import com.huoyushi.jms.RegisterProducer;
import com.huoyushi.util.ActiveMQListener;

@Service("UserManagerService")
public class UserManagerImpl implements UserManager{

	@Autowired(required=true)
	private UserManagerDAO userManagerDao;
	  @Autowired (required=true)
	    private RegisterProducer producer; 
	  @Autowired (required=true)
	    private RegisterConsumer consumer;
	
	  @Autowired  
	 @Qualifier("queueDestination") 
	    private Destination destination; 
	@Override
	public Object login(String id, String psd,int groupid) {
		if(groupid==2)
			return userManagerDao.findCustomer(id, psd);
		if(groupid==1)
			return userManagerDao.findSeller(id, psd);
		return null;
	}

	@Override
	@Transactional
	public String registerSeller(Seller seller) {
		producer.sendMessage(destination,seller);
		if(userManagerDao.addSeller(seller))
			return "getrequest";
	    return "used";
		
	}
	
	@Override
	public List<Seller> getpendinglist(int flag) throws Exception{
		List<Seller>userlist=new ArrayList<>();
		long total=ActiveMQListener.getMessageNum();
		long max=0;
		if(total>5)
		 max=5;
		else {
			max=total;
		}
		if(flag==1){if(total>1)max=1;else {
			max=0;
		}}
			for(int i=0;i<max;i++){
				Seller user=consumer.Receive(destination);
				userlist.add(user);
			}
		return userlist;
	}

	@Override
	@Transactional
	public String registerCustomer(Customer customer) {
		System.out.println("service cus");
		System.out.println(customer.getCustomerid());
		if (userManagerDao.addCustomer(customer))
		return "Success";
		return "used";
	}
	@Override
	public List<Seller> getSellers() {
		return userManagerDao.findSellerlist();
	}

	@Override
	@Transactional
	public boolean authorize(String sellerid) {
		return userManagerDao.authorize(sellerid);
	}
}
